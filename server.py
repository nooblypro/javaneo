#!/usr/bin/env python3
"""Local Java practice server. Run: python3 server.py, then open http://127.0.0.1:8000"""
import json, re, subprocess
from http.server import ThreadingHTTPServer, BaseHTTPRequestHandler
from pathlib import Path
from urllib.parse import urlparse

ROOT = Path(__file__).resolve().parent
PROBLEMS = ROOT / "problems"
PROBLEMS.mkdir(exist_ok=True)
ID_RE = re.compile(r"^[a-z0-9_-]{1,40}$")
TIMEOUT = 2  # seconds per test case
DEFAULT_CODE = """import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
}
"""

def check_id(pid):
    if not ID_RE.match(pid):
        raise ValueError("id must be lowercase letters, digits, - or _")
    return PROBLEMS / pid

def norm(s):
    return "\n".join(line.rstrip() for line in s.strip().splitlines())

def list_problems():
    out = []
    for d in sorted(PROBLEMS.iterdir()):
        f = d / "problem.json"
        if d.is_dir() and f.exists():
            data = json.loads(f.read_text())
            out.append({"id": d.name, "title": data.get("title") or d.name, "topic": data.get("topic", "other")})
    return out

def get_problem(pid):
    d = check_id(pid)
    meta = json.loads((d / "problem.json").read_text())
    # For footer problems student code lives in Solution.java after the first run
    if meta.get("footer") and (d / "Solution.java").exists():
        meta["code"] = (d / "Solution.java").read_text()
    else:
        meta["code"] = (d / "Main.java").read_text()
    return meta

def save_problem(pid, data):
    d = check_id(pid)
    cases = [{"input": str(c.get("input", "")), "expected": str(c.get("expected", ""))}
             for c in data.get("cases", [])]
    meta = {"title": str(data.get("title", pid)), "statement": str(data.get("statement", "")), "cases": cases}
    if "footer" in data and isinstance(data["footer"], str):
        meta["footer"] = data["footer"]
    (d / "problem.json").write_text(json.dumps(meta, indent=2))

def create_problem(data):
    pid = data.get("id", "")
    d = check_id(pid)
    if d.exists():
        raise ValueError("a problem with that id already exists")
    d.mkdir()
    (d / "Main.java").write_text(DEFAULT_CODE)
    save_problem(pid, data)
    return {"ok": True}

def save_code(pid, code):
    d = check_id(pid)
    (d / "Main.java").write_text(code)
    return {"ok": True}

def run_problem(pid):
    d = check_id(pid)
    meta = json.loads((d / "problem.json").read_text())
    student_code = (d / "Main.java").read_text()
    footer = meta.get("footer")

    if footer:
        if "public class Main" in student_code:
            return {"compile_error": "Your code must not declare public class Main. Write only the helper classes."}
        (d / "Solution.java").write_text(student_code)
        (d / "Main.java").write_text(footer)
        compiled = subprocess.run(["javac", "Main.java", "Solution.java"], cwd=d, capture_output=True, text=True)
    else:
        compiled = subprocess.run(["javac", "Main.java"], cwd=d, capture_output=True, text=True)

    if compiled.returncode != 0:
        return {"compile_error": compiled.stderr or "compilation failed"}
    results = []
    for case in meta["cases"]:
        try:
            p = subprocess.run(["java", "-cp", str(d), "Main"], input=case["input"],
                               capture_output=True, text=True, timeout=TIMEOUT, cwd=d)
            if p.returncode != 0:
                status = "runtime_error"
            elif norm(p.stdout) == norm(case["expected"]):
                status = "pass"
            else:
                status = "fail"            
            results.append({"status": status, "expected": case["expected"],
                            "actual": p.stdout, "error": p.stderr})
        except subprocess.TimeoutExpired:
            results.append({"status": "timeout", "expected": case["expected"],
                            "actual": f"(stopped after {TIMEOUT} s, possible infinite loop)", "error": ""})
    return {"results": results}

CURRICULUM = ROOT / "curriculum.json"
ALLOWED_TOPICS = {"oop", "inheritance", "interfaces", "exceptions", "threads",
                  "stringbuilder", "generics", "arraylist", "hashmap",
                  "serialization", "file-io", "arrays", "math-basics", "other"}

def import_curriculum():
    if not CURRICULUM.exists():
        raise ValueError("curriculum.json not found in the project folder")
    try:
        items = json.loads(CURRICULUM.read_text(encoding="utf-8"))
    except json.JSONDecodeError as e:
        raise ValueError(f"curriculum.json is not valid JSON: {e}")
    if not isinstance(items, list):
        raise ValueError("curriculum.json must be a JSON array")

    # Validate every entry before writing anything.
    seen = set()
    for item in items:
        pid = str(item.get("id", ""))
        if not ID_RE.match(pid):
            raise ValueError(f"bad id: {pid!r}")
        if pid in seen:
            raise ValueError(f"duplicate id: {pid}")
        seen.add(pid)
        if item.get("topic") not in ALLOWED_TOPICS:
            raise ValueError(f"{pid}: topic not allowed")
        cases = item.get("cases") or []
        if not cases:
            raise ValueError(f"{pid}: no cases")
        for c in cases:
            if not isinstance(c.get("input"), str) or not isinstance(c.get("expected"), str):
                raise ValueError(f"{pid}: each case needs string input and expected")
        if "footer" in item and not isinstance(item["footer"], str):
            raise ValueError(f"{pid}: footer must be a string")

    created, updated = [], []
    for item in items:
        pid = item["id"]
        d = PROBLEMS / pid
        existed = d.exists()
        d.mkdir(exist_ok=True)
        meta = {
            "title": str(item.get("title", pid)),
            "topic": item["topic"],
            "statement": str(item.get("statement", "")),
            "cases": [{"input": c["input"], "expected": c["expected"]} for c in item["cases"]],
        }
        if "footer" in item:
            meta["footer"] = item["footer"]
        (d / "problem.json").write_text(json.dumps(meta, indent=2, ensure_ascii=False), encoding="utf-8")
        if not (d / "Main.java").exists():  # never overwrite existing code
            (d / "Main.java").write_text(DEFAULT_CODE)
        (updated if existed else created).append(pid)
    return {"created": created, "updated": updated}

class Handler(BaseHTTPRequestHandler):
    def log_message(self, *args):
        pass  # keep the terminal quiet

    def send_json(self, status, obj):
        data = json.dumps(obj).encode()
        self.send_response(status)
        self.send_header("Content-Type", "application/json")
        self.send_header("Content-Length", str(len(data)))
        self.end_headers()
        self.wfile.write(data)

    def body(self):
        n = int(self.headers.get("Content-Length", 0))
        return json.loads(self.rfile.read(n) or b"{}")

    def handle_api(self, method):
        path = urlparse(self.path).path
        try:
            if method == "POST" and path == "/api/import":
                return self.send_json(200, import_curriculum())
            if method == "GET" and path == "/api/problems":
                try:
                    import_curriculum()
                except ValueError as e:
                    print(f"auto-import: {e}")
                return self.send_json(200, list_problems())
            if method == "POST" and path == "/api/problems":
                return self.send_json(200, create_problem(self.body()))
            m = re.fullmatch(r"/api/problems/([^/]+)(/code|/run)?", path)
            if m:
                pid, action = m.group(1), m.group(2)
                if method == "GET" and not action:
                    try:
                        import_curriculum()
                    except ValueError as e:
                        print(f"auto-import: {e}")
                    return self.send_json(200, get_problem(pid))
                if method == "PUT" and not action:
                    save_problem(pid, self.body())
                    return self.send_json(200, {"ok": True})
                if method == "PUT" and action == "/code":
                    return self.send_json(200, save_code(pid, self.body()["code"]))
                if method == "POST" and action == "/run":
                    return self.send_json(200, run_problem(pid))
            self.send_json(404, {"error": "not found"})
        except Exception as e:
            self.send_json(400, {"error": str(e)})

    def do_GET(self):
        if urlparse(self.path).path == "/":
            data = (ROOT / "index.html").read_bytes()
            self.send_response(200)
            self.send_header("Content-Type", "text/html; charset=utf-8")
            self.send_header("Content-Length", str(len(data)))
            self.end_headers()
            self.wfile.write(data)
        else:
            self.handle_api("GET")

    def do_POST(self):
        self.handle_api("POST")

    def do_PUT(self):
        self.handle_api("PUT")

if __name__ == "__main__":
    try:
        import_curriculum()
    except ValueError as e:
        print(f"auto-import: {e}")
    server = ThreadingHTTPServer(("127.0.0.1", 8000), Handler)  # localhost only
    print("Open http://127.0.0.1:8000  (Ctrl+C to stop)")
    server.serve_forever()
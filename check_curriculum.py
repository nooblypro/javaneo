#!/usr/bin/env python3
"""Run reference solutions against curriculum.json test cases."""
import json
import subprocess
import sys
import tempfile
from pathlib import Path

ROOT = Path(__file__).resolve().parent
CURRICULUM_PATH = ROOT / "curriculum.json"
SOLUTIONS_DIR = ROOT / "solutions"
TIMEOUT = 5  # seconds per test case


def norm(s):
    return "\n".join(line.rstrip() for line in (s or "").strip().splitlines())


def check_all():
    if not CURRICULUM_PATH.exists():
        print(f"Error: {CURRICULUM_PATH} does not exist.")
        return False

    with open(CURRICULUM_PATH, "r", encoding="utf-8") as f:
        curriculum = json.load(f)

    all_passed = True

    for problem in curriculum:
        pid = problem.get("id")
        footer = problem.get("footer")

        if footer:
            solution_java = SOLUTIONS_DIR / pid / "Solution.java"
            if not solution_java.exists():
                print(f"[{pid}] ERROR: Missing solution file at {solution_java}")
                all_passed = False
                continue
        else:
            solution_java = SOLUTIONS_DIR / pid / "Main.java"
            if not solution_java.exists():
                print(f"[{pid}] ERROR: Missing solution file at {solution_java}")
                all_passed = False
                continue

        with tempfile.TemporaryDirectory() as td:
            if footer:
                # Write Solution.java and Main.java (footer)
                (Path(td) / "Solution.java").write_text(solution_java.read_text(encoding="utf-8"), encoding="utf-8")
                (Path(td) / "Main.java").write_text(footer, encoding="utf-8")
                comp = subprocess.run(["javac", "Main.java", "Solution.java"], cwd=td, capture_output=True, text=True)
            else:
                # Copy Main.java to isolated tempdir
                src_dest = Path(td) / "Main.java"
                src_dest.write_text(solution_java.read_text(encoding="utf-8"), encoding="utf-8")
                comp = subprocess.run(["javac", "Main.java"], cwd=td, capture_output=True, text=True)

            if comp.returncode != 0:
                print(f"[{pid}] COMPILE ERROR:\n{comp.stderr.strip()}")
                all_passed = False
                continue

            cases = problem.get("cases", [])
            for idx, case in enumerate(cases):
                inp = case.get("input", "")
                expected = case.get("expected", "")

                try:
                    p = subprocess.run(
                        ["java", "-cp", td, "Main"],
                        input=inp,
                        cwd=td,
                        capture_output=True,
                        text=True,
                        timeout=TIMEOUT,
                    )
                    if p.returncode != 0:
                        print(f"[{pid}] Case {idx}: FAIL (Runtime Error)")
                        print(f"  Error:\n{p.stderr.strip()}")
                        all_passed = False
                        continue

                    actual_norm = norm(p.stdout)
                    expected_norm = norm(expected)

                    if actual_norm == expected_norm:
                        print(f"[{pid}] Case {idx}: PASS")
                    else:
                        print(f"[{pid}] Case {idx}: FAIL")
                        print(f"  Expected: {repr(expected)}")
                        print(f"  Actual:   {repr(p.stdout)}")
                        all_passed = False
                except subprocess.TimeoutExpired:
                    print(f"[{pid}] Case {idx}: FAIL (Timeout after {TIMEOUT}s)")
                    all_passed = False

    return all_passed


if __name__ == "__main__":
    success = check_all()
    sys.exit(0 if success else 1)

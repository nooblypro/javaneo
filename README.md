# JavaNeo 🚀

A lightweight, local-first Java coding practice platform with real-time compilation, test case verification, and a modern sky-blue themed web UI.

---

## Features

- **23 Java Practice Problems**: Ranging from OOP, inheritance, interfaces, exceptions, multithreading, collections, file I/O, to serialization.
- **In-Browser Code Editor**: Code editor with line numbers, auto-indentation, and standard Java starter templates.
- **Live Local Execution**: Compiles and runs Java code directly against test cases on your local machine using your JDK.
- **Visual Progress Tracking**: Status color indicators for viewed (yellow), passed (green), and failed/error (red) problems.
- **Zero Third-Party Dependencies**: Backend runs purely on standard Python 3; frontend runs on vanilla HTML5/CSS3/JavaScript.

---

## Prerequisites

1. **Python 3** (version 3.8+)
2. **Java JDK** (`javac` and `java` in your `PATH`, e.g., OpenJDK 17 or higher)

Check your environment:
```bash
python3 --version
javac -version
java -version
```

---

## Quick Start

1. **Clone the repository:**
   ```bash
   git clone https://github.com/nooblypro/javaneo.git
   cd javaneo
   ```

2. **Start the server:**
   ```bash
   python3 server.py
   ```

3. **Open the app in your browser:**
   ```
   http://127.0.0.1:8000
   ```

---

## Running Automated Curriculum Checks

To verify all 23 reference solutions against the test cases:
```bash
python3 check_curriculum.py
```

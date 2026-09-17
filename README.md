# 🚀 ConstraintCraft

### Smart Constraint Solving & Conflict Detection System

> A Java-based command-line system that solves real-world allocation and scheduling problems using **constraints, conflict detection, and backtracking**.

---

## ✨ What It Does

ConstraintCraft transforms allocation and scheduling problems into solvable constraint-based models.

- 🪑 **Exam Seating** — Assign students to seats while respecting seating rules.
- 🏫 **Room Allocation** — Assign classes to rooms using resource constraints.
- 📅 **Task Scheduling** — Schedule tasks into time slots while respecting ordering constraints.

---

## ⚡ Key Features

- 🧠 Backtracking-based solution engine
- 🔍 Contradictory constraint detection
- ⚙️ Multiple constraint types
- ✅ Input validation & exception handling
- ⏱️ Performance measurement
- 📄 Automatic solution reports
- 💻 Fully command-line based

---

## 🛠️ Built With

**Java 17** • **OOP** • **Recursion** • **Backtracking** • **Java Collections** • **Exception Handling** • **File Handling** • **Git & GitHub**

---

## 🔄 Workflow

    User Input
        ↓
    Validation
        ↓
    Constraint Management
        ↓
    Conflict Detection
        ↓
    Backtracking Solver
        ↓
    Valid Solution
        ↓
    Report Generation

---

## 📂 Project Structure

    ConstraintCraft/
    ├── src/
    │   ├── Main.java
    │   ├── model/
    │   ├── solver/
    │   ├── service/
    │   ├── scenario/
    │   ├── exception/
    │   └── util/
    ├── docs/
    │   ├── UseCaseDiagram.png
    │   ├── ClassDiagram.png
    │   ├── ComponentDiagram.png
    │   └── SequenceDiagram.png
    ├── screenshots/
    │   ├── ExamSeating.png
    │   ├── RoomAllocation.png
    │   ├── TaskScheduling.png
    │   └── ConflictDetection.png
    ├── tests/
    │   └── TestCases.md
    ├── reports/
    ├── data/
    ├── README.md
    ├── statement.md
    └── .gitignore

---

## ▶️ Run Locally

### Compile

    javac -d out (Get-ChildItem -Recurse src -Filter *.java | ForEach-Object { $_.FullName })

### Run

    java -cp out Main

---

## 🧪 Tested For

| Test | Result |
|---|---|
| 🪑 Valid Exam Seating | ✅ PASS |
| 🏫 Room Allocation | ✅ PASS |
| 📅 Task Scheduling | ✅ PASS |
| 🔍 Conflict Detection | ✅ PASS |
| ⚠️ Invalid Input Handling | ✅ PASS |

---

## 📐 Documentation

The project includes:

- 📌 Use Case Diagram
- 📌 Class Diagram
- 📌 Component Diagram
- 📌 Sequence Diagram
- 📌 Test Cases
- 📌 Project Statement
- 📌 Application Screenshots

---

## 🔮 Future Scope

**Resource Capacity** • **Advanced Constraints** • **Scheduling Optimization** • **Database Integration** • **Larger Datasets**

---

## 👩‍💻 Author

**Divya Pal**  


---

⭐ **ConstraintCraft — Turning complex constraints into valid solutions.**
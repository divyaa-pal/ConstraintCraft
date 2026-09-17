# ConstraintCraft - Project Statement

## 1. Problem Statement

Many real-world scheduling and allocation problems involve multiple rules and restrictions. Examples include arranging students for examinations, allocating subjects to rooms, and scheduling tasks into time slots.

When these problems are handled manually, conflicting requirements can be difficult to identify and valid arrangements can take considerable time to find.

ConstraintCraft provides a command-line Java solution that accepts entities, resources, and user-defined constraints, detects direct conflicts, and uses a backtracking algorithm to find a valid solution.

## 2. Project Objectives

The main objectives of ConstraintCraft are:

- To solve constraint-based allocation and scheduling problems.
- To implement a backtracking-based solution engine in Java.
- To detect contradictory constraints before solving.
- To provide input validation and error handling.
- To support multiple real-world scenarios.
- To generate a text report containing the solution and performance information.

## 3. Scope

ConstraintCraft currently supports three scenarios:

### Exam Seating

Assign students to seats while considering seating constraints.

### Room Allocation

Assign subjects or classes to available rooms.

### Task Scheduling

Assign tasks to available time slots while considering ordering constraints.

## 4. Target Users

The system can be useful for:

- Educational institutions
- Teachers and administrators
- Scheduling coordinators
- Students learning constraint-solving algorithms
- Users who need simple allocation and scheduling solutions

## 5. High-Level Features

- Exam seating management
- Room allocation
- Task scheduling
- Constraint management
- Conflict detection
- Backtracking solution engine
- Input validation
- Exception handling
- Performance measurement
- Automatic report generation

## 6. Input and Output

### Input

The user provides:

- Number of entities
- Entity names
- Number of available resources
- Constraints and restrictions

### Processing

The system:

1. Validates the input.
2. Stores entities and constraints.
3. Checks for direct conflicts.
4. Applies the backtracking algorithm.
5. Searches for a valid assignment.

### Output

The system displays:

- Constraints
- Conflict messages when applicable
- Valid assignments when found
- Backtracking attempts
- Execution time
- Generated report location

## 7. Project Limitations

The current version uses a simple resource-assignment model. Each entity is assigned to a unique resource, and the system does not currently model advanced factors such as resource capacity, multiple sessions, or optimization preferences.

## 8. Future Enhancements

Future versions may include:

- Resource capacity constraints
- More advanced scheduling rules
- Priority-based scheduling
- Larger datasets
- Database integration
- Additional constraint types
- Optimization techniques
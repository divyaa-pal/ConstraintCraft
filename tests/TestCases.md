# ConstraintCraft - Test Cases

## Test Case 1: Valid Exam Seating

Input:
- 4 students: A, B, C, D
- A cannot sit beside B
- C must sit beside D

Expected Result:
A valid seating arrangement should be generated.

Actual Result:
Valid arrangement found.

Status: PASS


## Test Case 2: Conflict Detection

Input:
- A cannot sit beside B
- A must sit beside B

Expected Result:
The system should detect contradictory constraints.

Actual Result:
Contradictory rules for A and B detected.

Status: PASS


## Test Case 3: Room Allocation

Input:
- 3 subjects
- 3 rooms

Expected Result:
Each subject should be assigned to a room.

Actual Result:
Subjects were assigned to available rooms.

Status: PASS


## Test Case 4: Task Scheduling

Input:
- 3 tasks
- 3 time slots

Expected Result:
Each task should be assigned to a time slot.

Actual Result:
Tasks were assigned to time slots.

Status: PASS


## Test Case 5: Invalid Input

Input:
A non-numeric value where a number is required.

Expected Result:
The system should display an error message and ask for valid input.

Status: PASS
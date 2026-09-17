package scenario;

import model.Entity;
import model.Problem;
import model.Solution;
import service.ConflictDetector;
import service.ConstraintManager;
import service.ReportGenerator;
import solver.BacktrackingSolver;

import java.util.List;
import java.util.Scanner;

public class ExamSeating {

    public void run(Scanner scanner) {

        System.out.println();
        System.out.println(
                "========== EXAM SEATING =========="
        );

        int students =
                readPositiveInt(
                        scanner,
                        "Enter number of students: "
                );

        Problem problem =
                new Problem(
                        "Exam_Seating",
                        students
                );

        for (int i = 1; i <= students; i++) {

            System.out.print(
                    "Enter student "
                            + i
                            + " name: "
            );

            String name =
                    scanner.nextLine().trim();

            if (name.isEmpty()) {

                i--;

                System.out.println(
                        "Name cannot be empty."
                );

                continue;
            }

            boolean duplicate =
                    problem.getEntities()
                            .stream()
                            .anyMatch(
                                    e -> e.getName()
                                            .equalsIgnoreCase(name)
                            );

            if (duplicate) {

                i--;

                System.out.println(
                        "Duplicate name."
                );

                continue;
            }

            problem.addEntity(
                    new Entity(name)
            );
        }

        ConstraintManager manager =
                new ConstraintManager(scanner);

        manager.addConstraints(problem);

        manager.showConstraints(problem);

        List<String> conflicts =
                new ConflictDetector()
                        .detect(problem);

        if (!conflicts.isEmpty()) {

            System.out.println();
            System.out.println(
                    "CONFLICT DETECTED"
            );

            conflicts.stream()
                    .distinct()
                    .forEach(
                            c -> System.out.println(
                                    "- " + c
                            )
                    );

            return;
        }

        Solution solution =
                new BacktrackingSolver()
                        .solve(problem);

        System.out.println();
        System.out.println(
                "========== RESULT =========="
        );

        if (!solution.isSolved()) {

            System.out.println(
                    "NO VALID ARRANGEMENT FOUND."
            );

        } else {

            System.out.println(
                    "Valid arrangement found!"
            );

            solution.getAssignments()
                    .forEach(
                            (name, seat) ->
                                    System.out.println(
                                            "Seat "
                                                    + seat
                                                    + " -> "
                                                    + name
                                    )
                    );

            System.out.println(
                    "Backtracking attempts: "
                            + solution
                            .getBacktrackingSteps()
            );

            System.out.printf(
                    "Execution time: %.3f ms%n",
                    solution
                            .getExecutionTimeNanos()
                            / 1_000_000.0
            );
        }

        new ReportGenerator()
                .saveReport(
                        problem,
                        solution
                );
    }

    private int readPositiveInt(
            Scanner scanner,
            String prompt) {

        while (true) {

            System.out.print(prompt);

            try {

                int number =
                        Integer.parseInt(
                                scanner.nextLine().trim()
                        );

                if (number > 0) {
                    return number;
                }

            } catch (Exception ignored) {
            }

            System.out.println(
                    "Enter a positive whole number."
            );
        }
    }
}
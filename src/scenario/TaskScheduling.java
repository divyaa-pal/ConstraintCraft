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

public class TaskScheduling {

    public void run(Scanner scanner) {

        System.out.println();
        System.out.println(
                "========== TASK SCHEDULING =========="
        );

        int tasks =
                readPositiveInt(
                        scanner,
                        "Enter number of tasks: "
                );

        int slots =
                readPositiveInt(
                        scanner,
                        "Enter number of time slots: "
                );

        Problem problem =
                new Problem(
                        "Task_Scheduling",
                        slots
                );

        for (int i = 1; i <= tasks; i++) {

            System.out.print(
                    "Enter task "
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

            if (problem.getEntities()
                    .stream()
                    .anyMatch(
                            e -> e.getName()
                                    .equalsIgnoreCase(name)
                    )) {

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
                    "No valid schedule found."
            );

        } else {

            solution.getAssignments()
                    .forEach(
                            (task, slot) ->
                                    System.out.println(
                                            task
                                                    + " -> Time Slot "
                                                    + slot
                                    )
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
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

public class RoomAllocation {

    public void run(Scanner scanner) {

        System.out.println();
        System.out.println(
                "========== ROOM ALLOCATION =========="
        );

        int classes =
                readPositiveInt(
                        scanner,
                        "Enter number of classes: "
                );

        int rooms =
                readPositiveInt(
                        scanner,
                        "Enter number of rooms: "
                );

        Problem problem =
                new Problem(
                        "Room_Allocation",
                        rooms
                );

        for (int i = 1; i <= classes; i++) {

            System.out.print(
                    "Enter class "
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
                    "No valid room allocation found."
            );

        } else {

            solution.getAssignments()
                    .forEach(
                            (name, room) ->
                                    System.out.println(
                                            name
                                                    + " -> Room "
                                                    + room
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
package service;

import exception.InvalidConstraintException;
import model.Constraint;
import model.Entity;
import model.Problem;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConstraintManager {

    private final Scanner scanner;

    public ConstraintManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addConstraints(Problem problem) {

        while (true) {

            System.out.println();
            System.out.println("---------- ADD CONSTRAINT ----------");
            System.out.println("1. Cannot sit beside");
            System.out.println("2. Must sit beside");
            System.out.println("3. Must be before");
            System.out.println("4. Must use a particular resource");
            System.out.println("5. Cannot use a particular resource");
            System.out.println("6. Finish adding constraints");

            int choice = readInt("Enter choice: ");

            try {

                Constraint constraint;

                switch (choice) {

                    case 1:
                        constraint = new Constraint(
                                Constraint.Type.NOT_ADJACENT,
                                readEntity(problem),
                                readEntity(problem)
                        );
                        break;

                    case 2:
                        constraint = new Constraint(
                                Constraint.Type.MUST_ADJACENT,
                                readEntity(problem),
                                readEntity(problem)
                        );
                        break;

                    case 3:
                        constraint = new Constraint(
                                Constraint.Type.BEFORE,
                                readEntity(problem),
                                readEntity(problem)
                        );
                        break;

                    case 4:
                        constraint = new Constraint(
                                Constraint.Type.FIXED_RESOURCE,
                                readEntity(problem),
                                readResource(problem)
                        );
                        break;

                    case 5:
                        constraint = new Constraint(
                                Constraint.Type.NOT_FIXED_RESOURCE,
                                readEntity(problem),
                                readResource(problem)
                        );
                        break;

                    case 6:
                        return;

                    default:
                        throw new InvalidConstraintException(
                                "Please choose a number from 1 to 6."
                        );
                }

                problem.addConstraint(constraint);

                System.out.println(
                        "Constraint added: " + constraint
                );

            } catch (
                    InvalidConstraintException
                    | IllegalArgumentException e) {

                System.out.println(
                        "Error: " + e.getMessage()
                );
            }
        }
    }

    public void showConstraints(Problem problem) {

        System.out.println();
        System.out.println(
                "---------- CURRENT CONSTRAINTS ----------"
        );

        if (problem.getConstraints().isEmpty()) {

            System.out.println("No constraints added.");
            return;
        }

        int number = 1;

        for (Constraint c :
                problem.getConstraints()) {

            System.out.println(
                    number++ + ". " + c
            );
        }
    }

    private String readEntity(Problem problem)
            throws InvalidConstraintException {

        System.out.print("Enter entity name: ");

        String name =
                scanner.nextLine().trim();

        if (name.isEmpty()) {

            throw new InvalidConstraintException(
                    "Entity name cannot be empty."
            );
        }

        Set<String> names = new HashSet<>();

        for (Entity entity :
                problem.getEntities()) {

            names.add(
                    entity.getName().toLowerCase()
            );
        }

        if (!names.contains(name.toLowerCase())) {

            throw new InvalidConstraintException(
                    "Entity not found."
            );
        }

        return name;
    }

    private String readResource(Problem problem)
            throws InvalidConstraintException {

        int resource = readInt(
                "Enter resource number (1-"
                        + problem.getResources()
                        + "): "
        );

        if (resource < 1
                || resource > problem.getResources()) {

            throw new InvalidConstraintException(
                    "Invalid resource number."
            );
        }

        return String.valueOf(resource);
    }

    private int readInt(String prompt) {

        while (true) {

            System.out.print(prompt);

            String input =
                    scanner.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }
}
import scenario.ExamSeating;
import scenario.RoomAllocation;
import scenario.TaskScheduling;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        System.out.println();
        System.out.println(
                "============================================"
        );
        System.out.println(
                "             CONSTRAINTCRAFT"
        );
        System.out.println(
                "       Smart Constraint Solving System"
        );
        System.out.println(
                "============================================"
        );

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println(
                    "=============== MAIN MENU ==============="
            );
            System.out.println("1. Exam Seating");
            System.out.println("2. Room Allocation");
            System.out.println("3. Task Scheduling");
            System.out.println("4. Exit");

            System.out.print(
                    "Enter your choice: "
            );

            String choice =
                    scanner.nextLine().trim();

            switch (choice) {

                case "1":
                    new ExamSeating()
                            .run(scanner);
                    break;

                case "2":
                    new RoomAllocation()
                            .run(scanner);
                    break;

                case "3":
                    new TaskScheduling()
                            .run(scanner);
                    break;

                case "4":

                    running = false;

                    System.out.println(
                            "Thank you for using ConstraintCraft!"
                    );

                    break;

                default:

                    System.out.println(
                            "Please choose 1, 2, 3, or 4."
                    );
            }
        }

        scanner.close();
    }
}
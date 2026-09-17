package service;

import model.Constraint;
import model.Problem;
import model.Solution;
import util.FileManager;

public class ReportGenerator {

    public String buildReport(
            Problem problem,
            Solution solution) {

        StringBuilder report =
                new StringBuilder();

        report.append("CONSTRAINTCRAFT REPORT\n");
        report.append("======================\n");

        report.append("Problem: ")
                .append(problem.getName())
                .append("\n");

        report.append("Entities: ")
                .append(problem.getEntities().size())
                .append("\n");

        report.append("Resources: ")
                .append(problem.getResources())
                .append("\n\n");

        report.append("Constraints:\n");

        for (Constraint constraint :
                problem.getConstraints()) {

            report.append("- ")
                    .append(constraint)
                    .append("\n");
        }

        report.append("\nResult: ")
                .append(
                        solution.isSolved()
                                ? "VALID SOLUTION FOUND"
                                : "NO VALID SOLUTION"
                )
                .append("\n");

        if (solution.isSolved()) {

            for (var entry :
                    solution.getAssignments().entrySet()) {

                report.append(entry.getKey())
                        .append(" -> Resource ")
                        .append(entry.getValue())
                        .append("\n");
            }
        }

        report.append(
                "Backtracking attempts: "
        )
                .append(
                        solution.getBacktrackingSteps()
                )
                .append("\n");

        report.append(
                "Execution time: "
        )
                .append(
                        solution.getExecutionTimeNanos()
                )
                .append(" ns\n");

        return report.toString();
    }

    public void saveReport(
            Problem problem,
            Solution solution) {

        String report =
                buildReport(problem, solution);

        String filename =
                problem.getName()
                        .replaceAll(
                                "[^a-zA-Z0-9_-]",
                                "_"
                        )
                        + "_report.txt";

        FileManager.saveToReports(
                filename,
                report
        );

        System.out.println(
                "Report saved in reports/"
                        + filename
        );
    }
}
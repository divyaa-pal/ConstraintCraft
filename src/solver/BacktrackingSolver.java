package solver;

import model.Constraint;
import model.Entity;
import model.Problem;
import model.Solution;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class BacktrackingSolver implements ConstraintSolver {

    private int steps;

    @Override
    public Solution solve(Problem problem) {

        long start = System.nanoTime();

        steps = 0;

        Map<String, Integer> assignment =
                new LinkedHashMap<>();

        if (problem.getEntities().size()
                > problem.getResources()) {

            return new Solution(
                    false,
                    assignment,
                    0,
                    System.nanoTime() - start
            );
        }

        boolean solved = backtrack(
                problem,
                0,
                assignment,
                new HashSet<>()
        );

        return new Solution(
                solved,
                assignment,
                steps,
                System.nanoTime() - start
        );
    }

    private boolean backtrack(
            Problem problem,
            int index,
            Map<String, Integer> assignment,
            Set<Integer> used) {

        if (index == problem.getEntities().size()) {
            return true;
        }

        Entity entity =
                problem.getEntities().get(index);

        for (int resource = 1;
             resource <= problem.getResources();
             resource++) {

            if (used.contains(resource)) {
                continue;
            }

            steps++;

            assignment.put(
                    entity.getName(),
                    resource
            );

            if (isConsistent(
                    problem,
                    entity.getName(),
                    resource,
                    assignment)) {

                used.add(resource);

                if (backtrack(
                        problem,
                        index + 1,
                        assignment,
                        used)) {

                    return true;
                }

                used.remove(resource);
            }

            assignment.remove(entity.getName());
        }

        return false;
    }

    private boolean isConsistent(
            Problem problem,
            String current,
            int position,
            Map<String, Integer> assignment) {

        for (Constraint c : problem.getConstraints()) {

            String a = c.getFirst();
            String b = c.getSecond();

            switch (c.getType()) {

                case NOT_ADJACENT:

                    if (assignment.containsKey(a)
                            && assignment.containsKey(b)
                            && Math.abs(
                                    assignment.get(a)
                                            - assignment.get(b)
                            ) == 1) {

                        return false;
                    }

                    break;

                case MUST_ADJACENT:

                    if (assignment.containsKey(a)
                            && assignment.containsKey(b)
                            && Math.abs(
                                    assignment.get(a)
                                            - assignment.get(b)
                            ) != 1) {

                        return false;
                    }

                    break;

                case BEFORE:

                    if (assignment.containsKey(a)
                            && assignment.containsKey(b)
                            && assignment.get(a)
                            >= assignment.get(b)) {

                        return false;
                    }

                    break;

                case FIXED_RESOURCE:

                    if (a.equals(current)
                            && !String.valueOf(position)
                            .equals(b)) {

                        return false;
                    }

                    break;

                case NOT_FIXED_RESOURCE:

                    if (a.equals(current)
                            && String.valueOf(position)
                            .equals(b)) {

                        return false;
                    }

                    break;
            }
        }

        return true;
    }
}
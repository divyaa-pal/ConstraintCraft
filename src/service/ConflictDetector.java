package service;

import model.Constraint;
import model.Problem;

import java.util.ArrayList;
import java.util.List;

public class ConflictDetector {

    public List<String> detect(Problem problem) {

        List<String> conflicts =
                new ArrayList<>();

        if (problem.getEntities().size()
                > problem.getResources()) {

            conflicts.add(
                    "More entities than available resources."
            );
        }

        for (Constraint first :
                problem.getConstraints()) {

            for (Constraint second :
                    problem.getConstraints()) {

                if (first == second) {
                    continue;
                }

                boolean samePair =
                        first.getFirst()
                                .equalsIgnoreCase(
                                        second.getFirst()
                                )
                        &&
                        first.getSecond()
                                .equalsIgnoreCase(
                                        second.getSecond()
                                );

                boolean contradictory =
                        (first.getType()
                                == Constraint.Type.NOT_ADJACENT
                        &&
                        second.getType()
                                == Constraint.Type.MUST_ADJACENT)

                        ||

                        (first.getType()
                                == Constraint.Type.MUST_ADJACENT
                        &&
                        second.getType()
                                == Constraint.Type.NOT_ADJACENT);

                if (samePair && contradictory) {

                    conflicts.add(
                            "Contradictory rules for "
                                    + first.getFirst()
                                    + " and "
                                    + first.getSecond()
                                    + "."
                    );
                }
            }
        }

        return conflicts;
    }
}
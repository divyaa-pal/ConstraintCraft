package solver;

import model.Problem;
import model.Solution;

public interface ConstraintSolver {

    Solution solve(Problem problem);
}
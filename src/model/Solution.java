package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    private final boolean solved;
    private final Map<String, Integer> assignments;
    private final int backtrackingSteps;
    private final long executionTimeNanos;

    public Solution(
            boolean solved,
            Map<String, Integer> assignments,
            int backtrackingSteps,
            long executionTimeNanos) {

        this.solved = solved;
        this.assignments = new LinkedHashMap<>(assignments);
        this.backtrackingSteps = backtrackingSteps;
        this.executionTimeNanos = executionTimeNanos;
    }

    public boolean isSolved() {
        return solved;
    }

    public Map<String, Integer> getAssignments() {
        return assignments;
    }

    public int getBacktrackingSteps() {
        return backtrackingSteps;
    }

    public long getExecutionTimeNanos() {
        return executionTimeNanos;
    }
}
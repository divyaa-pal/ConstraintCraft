package model;

public class Constraint {

    public enum Type {
        NOT_ADJACENT,
        MUST_ADJACENT,
        BEFORE,
        FIXED_RESOURCE,
        NOT_FIXED_RESOURCE
    }

    private final Type type;
    private final String first;
    private final String second;

    public Constraint(Type type, String first, String second) {

        if (type == null || first == null || first.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid constraint.");
        }

        this.type = type;
        this.first = first.trim();
        this.second = second == null ? "" : second.trim();
    }

    public Type getType() {
        return type;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    @Override
    public String toString() {

        switch (type) {

            case NOT_ADJACENT:
                return first + " cannot be beside " + second;

            case MUST_ADJACENT:
                return first + " must be beside " + second;

            case BEFORE:
                return first + " must be before " + second;

            case FIXED_RESOURCE:
                return first + " must use resource " + second;

            case NOT_FIXED_RESOURCE:
                return first + " cannot use resource " + second;

            default:
                return type + ": " + first + " -> " + second;
        }
    }
}
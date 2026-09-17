package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem {

    private final String name;
    private final List<Entity> entities = new ArrayList<>();
    private final List<Constraint> constraints = new ArrayList<>();
    private int resources;

    public Problem(String name, int resources) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Problem name cannot be empty."
            );
        }

        if (resources <= 0) {
            throw new IllegalArgumentException(
                    "Resources must be greater than zero."
            );
        }

        this.name = name.trim();
        this.resources = resources;
    }

    public void addEntity(Entity entity) {

        if (entity == null) {
            throw new IllegalArgumentException(
                    "Entity cannot be null."
            );
        }

        entities.add(entity);
    }

    public void addConstraint(Constraint constraint) {

        if (constraint == null) {
            throw new IllegalArgumentException(
                    "Constraint cannot be null."
            );
        }

        constraints.add(constraint);
    }

    public String getName() {
        return name;
    }

    public List<Entity> getEntities() {
        return Collections.unmodifiableList(entities);
    }

    public List<Constraint> getConstraints() {
        return Collections.unmodifiableList(constraints);
    }

    public int getResources() {
        return resources;
    }

    public void setResources(int resources) {

        if (resources <= 0) {
            throw new IllegalArgumentException(
                    "Resources must be greater than zero."
            );
        }

        this.resources = resources;
    }
}
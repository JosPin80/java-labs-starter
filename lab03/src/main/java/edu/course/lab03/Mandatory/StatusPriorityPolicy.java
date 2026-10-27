package edu.course.lab03.Mandatory;

public class StatusPriorityPolicy implements PriorityPolicy{
    @Override
    public int calculatePriority(ProjectTask task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        return switch (task.getStatus()) {
            case IN_PROGRESS -> 3;
            case TODO -> 2;
            case DONE -> 1;
            default -> throw new IllegalStateException("Unknown status");
        };
    }
}

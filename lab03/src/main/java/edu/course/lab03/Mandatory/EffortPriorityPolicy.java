package edu.course.lab03.Mandatory;

public class EffortPriorityPolicy implements PriorityPolicy{
    @Override
    public int calculatePriority(ProjectTask task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        return task.getEstimatedHours();
    }

}

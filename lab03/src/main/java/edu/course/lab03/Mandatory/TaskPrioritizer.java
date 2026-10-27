package edu.course.lab03.Mandatory;

public class TaskPrioritizer {
    private final PriorityPolicy policy;

    public TaskPrioritizer(PriorityPolicy policy) {
        if (policy == null) {
            throw new IllegalArgumentException("Policy cannot be null");
        }
        this.policy = policy;
    }
    public ProjectTask chooseHigherPriority(
            ProjectTask first,
            ProjectTask second
    )  {

        int firstPrioritizer = policy.calculatePriority(first);
        int secondPrioritizer = policy.calculatePriority(second);

        if (firstPrioritizer >= secondPrioritizer) {
            return first;
        }

        return second;
    }
}

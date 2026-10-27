package edu.course.lab03.Mandatory;

public class ProjectTask {
    private final String id;
    private final String title;
    private TaskStatus status;
    private int estimatedHours;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

    public enum TaskStatus {
        TODO,
        IN_PROGRESS,
        DONE
    }


    public ProjectTask(String id, String title, TaskStatus status, int estimatedHours) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException(
                    "Nothing is being passed to the [String id]"
            );
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(
                    "Nothing is being passed to the [String title]"
            );
        }
        if (status == null) {
            throw new IllegalArgumentException(
                    "Nothing is being passed to the [TaskStatus status]"
            );
        }
        if (estimatedHours < 0) {
            throw new IllegalArgumentException(
                    "estimatedHours cannot be negative [int estimatedHours]"
            );
        }

        this.id = id;
        this.title = title;
        this.status = status;
        this.estimatedHours = estimatedHours;
    }

    public void changeStatus(TaskStatus amount) {
        if (amount == null) {
            throw new IllegalArgumentException(
                    "Nothing is being passed to the [TaskStatus status]"
            );
        }

        status = amount;
    }

    public void increaseEstimatedHours(int hours) {
        if (hours <= 0) {
            throw new IllegalArgumentException(
                    "estimatedHours cannot be negative [int estimatedHours]"
            );
        }

        estimatedHours += hours;
    }
}

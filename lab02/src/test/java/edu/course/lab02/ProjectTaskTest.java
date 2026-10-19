package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ProjectTaskTest {
    /// Правельность заполнения
    @Test
    void createsTaskWithValidValues() {
        ProjectTask task = new ProjectTask(
                "task_1",
                "test ProjectTask",
                ProjectTask.TaskStatus.TODO,
                67
        );

        assertEquals("task_1", task.getId());
        assertEquals("test ProjectTask", task.getTitle());
        assertEquals(ProjectTask.TaskStatus.TODO, task.getStatus());
        assertEquals(67, task.getEstimatedHours());

    }

    /// Просмотр правельности вывода исключений
    @Test
    void rejectsNullId() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask(
                        null, "Task", ProjectTask.TaskStatus.TODO, 5));
    }

    @Test
    void rejectsEmptyId() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask(
                        "", "Task", ProjectTask.TaskStatus.TODO, 5));
    }

    @Test
    void rejectsNullTitle() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask(
                        "TASK-1", null, ProjectTask.TaskStatus.TODO, 5));
    }

    @Test
    void rejectsEmptyTitle() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask(
                        "TASK-1", "", ProjectTask.TaskStatus.TODO, 5));
    }

    @Test
    void rejectsNullStatus() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask("TASK-1", "Task", null, 5));
    }

    @Test
    void rejectsNegativeEstimatedHours() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProjectTask(
                        "TASK-1", "Task", ProjectTask.TaskStatus.TODO, -1));
    }

    @Test
    void changesStatus() {
        ProjectTask task = new ProjectTask(
                "TASK-1", "Task", ProjectTask.TaskStatus.TODO, 5);

        task.changeStatus(ProjectTask.TaskStatus.DONE);

        assertEquals(ProjectTask.TaskStatus.DONE, task.getStatus());
    }

    @Test
    void rejectsNullWhenChangingStatus() {
        ProjectTask task = new ProjectTask(
                "TASK-1", "Task", ProjectTask.TaskStatus.TODO, 5);

        assertThrows(
                IllegalArgumentException.class,
                () -> task.changeStatus(null)
        );
    }

    @Test
    void increasesEstimatedHours() {
        ProjectTask task = new ProjectTask(
                "TASK-1", "Task", ProjectTask.TaskStatus.TODO, 5);

        task.increaseEstimatedHours(3);

        assertEquals(8, task.getEstimatedHours());
    }

    @Test
    void rejectsZeroHoursIncrease() {
        ProjectTask task = new ProjectTask(
                "TASK-1", "Task", ProjectTask.TaskStatus.TODO, 5);

        assertThrows(
                IllegalArgumentException.class,
                () -> task.increaseEstimatedHours(0)
        );
    }

    @Test
    void rejectsNegativeHoursIncrease() {
        ProjectTask task = new ProjectTask(
                "TASK-1", "Task", ProjectTask.TaskStatus.TODO, 5);

        assertThrows(
                IllegalArgumentException.class,
                () -> task.increaseEstimatedHours(-2)
        );
    }


}

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
    void rejectsEmptyId() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new ProjectTask(
                    "",
                    "",
                    ProjectTask.TaskStatus.TODO,
                    -1
            )
        );
    }

}

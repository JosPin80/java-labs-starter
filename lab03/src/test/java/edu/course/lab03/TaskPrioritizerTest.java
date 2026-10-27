package edu.course.lab03.Mandatory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskPrioritizerTest {

    private ProjectTask createTask(
            String id,
            ProjectTask.TaskStatus status,
            int hours
    ) {
        return new ProjectTask(
                id,
                "Test task",
                status,
                hours
        );
    }

    // TEST 1
    @Test
    void effortPolicyReturnsHours() {
        PriorityPolicy policy = new EffortPriorityPolicy();

        ProjectTask task = createTask(
                "TASK-1",
                ProjectTask.TaskStatus.TODO,
                10
        );

        assertEquals(10, policy.calculatePriority(task));
    }

    // TEST 2
    @Test
    void effortPolicyHandlesZeroHours() {
        PriorityPolicy policy = new EffortPriorityPolicy();

        ProjectTask task = createTask(
                "TASK-2",
                ProjectTask.TaskStatus.TODO,
                0
        );

        assertEquals(0, policy.calculatePriority(task));
    }

    // TEST 3
    @Test
    void effortPolicyRejectsNull() {
        PriorityPolicy policy = new EffortPriorityPolicy();

        assertThrows(
                IllegalArgumentException.class,
                () -> policy.calculatePriority(null)
        );
    }

    // TEST 4
    @Test
    void statusPolicyReturnsCorrectPriority() {
        PriorityPolicy policy = new StatusPriorityPolicy();

        ProjectTask task = createTask(
                "TASK-1",
                ProjectTask.TaskStatus.IN_PROGRESS,
                5
        );

        assertEquals(3, policy.calculatePriority(task));
    }

    // TEST 5
    @Test
    void statusPolicyHandlesDoneTask() {
        PriorityPolicy policy = new StatusPriorityPolicy();

        ProjectTask task = createTask(
                "TASK-2",
                ProjectTask.TaskStatus.DONE,
                10
        );

        assertEquals(1, policy.calculatePriority(task));
    }

    // TEST 6
    @Test
    void statusPolicyRejectsNull() {
        PriorityPolicy policy = new StatusPriorityPolicy();

        assertThrows(
                IllegalArgumentException.class,
                () -> policy.calculatePriority(null)
        );
    }

    // TEST 7
    @Test
    void prioritizerChoosesByEffort() {
        ProjectTask first = createTask(
                "TASK-1",
                ProjectTask.TaskStatus.TODO,
                10
        );

        ProjectTask second = createTask(
                "TASK-2",
                ProjectTask.TaskStatus.IN_PROGRESS,
                5
        );

        TaskPrioritizer prioritizer =
                new TaskPrioritizer(new EffortPriorityPolicy());

        assertSame(
                first,
                prioritizer.chooseHigherPriority(first, second)
        );
    }

    // TEST 8
    @Test
    void prioritizerChoosesByStatus() {
        ProjectTask first = createTask(
                "TASK-1",
                ProjectTask.TaskStatus.TODO,
                10
        );

        ProjectTask second = createTask(
                "TASK-2",
                ProjectTask.TaskStatus.IN_PROGRESS,
                5
        );

        TaskPrioritizer prioritizer =
                new TaskPrioritizer(new StatusPriorityPolicy());

        assertSame(
                second,
                prioritizer.chooseHigherPriority(first, second)
        );
    }

    // TEST 9
    @Test
    void prioritizerRejectsNullPolicy() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new TaskPrioritizer(null)
        );
    }

    // TEST 10
    @Test
    void prioritizerReturnsFirstWhenPrioritiesEqual() {
        ProjectTask first = createTask(
                "TASK-1",
                ProjectTask.TaskStatus.TODO,
                5
        );

        ProjectTask second = createTask(
                "TASK-2",
                ProjectTask.TaskStatus.DONE,
                5
        );

        TaskPrioritizer prioritizer =
                new TaskPrioritizer(new EffortPriorityPolicy());

        assertSame(
                first,
                prioritizer.chooseHigherPriority(first, second)
        );
    }
}
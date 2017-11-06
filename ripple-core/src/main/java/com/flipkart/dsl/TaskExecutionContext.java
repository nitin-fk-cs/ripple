package com.flipkart.dsl;

import com.flipkart.ripple.core.TaskStatus;

/**
 * Created by nitin.s on 02/11/17.
 */
public class TaskExecutionContext implements ExecutionContext {
    private TaskStatus taskStatus;

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }
}

package com.flipkart.dsl.taskDsl;

import com.flipkart.dsl.ExecutionContext;
import com.flipkart.dsl.State;
import com.flipkart.ripple.core.Node;
import com.flipkart.ripple.core.TaskProcessor;
import com.flipkart.ripple.core.TaskStatus;

/**
 * Created by gaurav.ss on 12/08/17.
 */
public abstract class TaskState implements State {
    protected TaskStatus taskStatus;
    protected TaskProcessor taskProcessor;

    public TaskState(TaskStatus taskStatus, TaskProcessor taskProcessor) {
        this.taskStatus = taskStatus;
        this.taskProcessor = taskProcessor;
    }

    public void performOperation(Node taskNode, ExecutionContext context) {
    }

}

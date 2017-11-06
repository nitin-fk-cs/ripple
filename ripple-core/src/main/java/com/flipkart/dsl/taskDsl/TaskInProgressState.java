package com.flipkart.dsl.taskDsl;

import com.flipkart.dsl.ExecutionContext;
import com.flipkart.ripple.core.Node;
import com.flipkart.ripple.core.TaskProcessor;
import com.flipkart.ripple.core.TaskStatus;

/**
 * Created by gaurav.ss on 14/08/17.
 */
public class TaskInProgressState extends TaskState {


    public TaskInProgressState(TaskStatus taskStatus, TaskProcessor taskProcessor) {
        super(taskStatus, taskProcessor);
    }

    public void performOperation(Node node, ExecutionContext executionContext) {

    }
}


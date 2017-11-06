package com.flipkart.dsl.taskDsl;

import com.flipkart.dsl.ExecutionContext;
import com.flipkart.ripple.core.Node;
import com.flipkart.ripple.core.TaskProcessor;
import com.flipkart.ripple.core.TaskStatus;

/**
 * Created by gaurav.ss on 13/08/17.
 */
public class TaskFailureState extends TaskState {

    public TaskFailureState(TaskStatus taskStatus, TaskProcessor taskProcessor) {
        super(taskStatus, taskProcessor);
    }

    @Override
    public void performOperation(Node node, ExecutionContext context) {
    }
}

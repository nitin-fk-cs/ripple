package com.flipkart.dsl.taskDsl;

import com.flipkart.dsl.ExecutionContext;
import com.flipkart.dsl.TaskExecutionContext;
import com.flipkart.ripple.core.Node;
import com.flipkart.ripple.core.TaskNode;
import com.flipkart.ripple.core.TaskProcessor;
import com.flipkart.ripple.core.TaskStatus;

/**
 * Created by gaurav.ss on 13/08/17.
 */
public class TaskWaitState extends TaskState {

    public TaskWaitState(TaskStatus taskStatus, TaskProcessor taskProcessor) {
        super(taskStatus, taskProcessor);
    }

    public void performOperation(Node node, ExecutionContext executionContext) {
        if(!(node instanceof TaskNode)) {
            throw new IllegalArgumentException("node must of type tasknode to perform operation");
        }
        TaskExecutionContext context = (TaskExecutionContext) executionContext;
        TaskNode taskNode = (TaskNode)node;
        TaskStatus executionStatus = context.getTaskStatus();
        if(executionStatus == TaskStatus.FAILED) {
            taskNode.setTaskState(new TaskSuccessState(taskStatus, taskProcessor));
        }
        if(executionStatus == TaskStatus.SUCCESSFUL) {
            taskNode.setTaskState(new TaskSuccessState(taskStatus, taskProcessor));
        }

    }
}

package com.flipkart.dsl.taskDsl;

import com.flipkart.dsl.ExecutionContext;
import com.flipkart.ripple.core.*;

/**
 * Created by gaurav.ss on 13/08/17.
 */
public class TaskInitState extends TaskState {

    public TaskInitState(TaskStatus taskStatus, TaskProcessor taskProcessor) {
        super(taskStatus, taskProcessor);
    }

    public void performOperation(Node node, ExecutionContext executionContext) {
        if(!(node instanceof TaskNode)) {
            throw new IllegalArgumentException("node must of type tasknode to perform operation");
        }
        TaskNode taskNode = (TaskNode)(node);
        TaskStatus taskStatus = taskProcessor.process(taskNode.getCurrentTask(), taskNode.getWorkflowThread().getWorkflow());
        if(taskStatus == TaskStatus.SUCCESSFUL) {
            taskNode.setTaskState(new TaskSuccessState(taskStatus, taskProcessor));
        } else if(taskStatus == TaskStatus.WAITING) {
            taskNode.setTaskState(new TaskWaitState(taskStatus, taskProcessor));
        }
    }
}

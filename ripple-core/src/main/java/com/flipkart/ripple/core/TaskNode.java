package com.flipkart.ripple.core;

import com.flipkart.dao.TaskNodeDAO;
import com.flipkart.dsl.ExecutionContext;
import com.flipkart.dsl.TaskExecutionContext;
import com.flipkart.dsl.taskDsl.TaskState;
import com.flipkart.ripple.core.meta.TaskMetaNode;
import com.google.inject.Inject;

import java.util.List;

/**
 * Created by mayank on 31/07/17.
 */
public class TaskNode extends Node<TaskMetaNode> {

    private List<Task> tasksPerformed;
    private WorkflowThread workflowThread;
    private Task currentTask;
    private TaskState taskState;
    private final TaskNodeDAO taskNodeDAO;

    @Inject
    public TaskNode(TaskMetaNode metaNode, List<Node> parentNodes, TaskNodeDAO taskNodeDAO) {
        super(metaNode, parentNodes);
        this.taskNodeDAO = taskNodeDAO;
    }

    public WorkflowThread getWorkflowThread() {
        return workflowThread;
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    public void setTaskState(TaskState taskState) {
        this.taskState = taskState;
    }

    public void execute(ExecutionContext context) {
        if(!(context instanceof TaskExecutionContext)) {
            throw new IllegalArgumentException("TaskExecution context required for task execution");
        }
        taskState.performOperation(this, context);
        taskNodeDAO.persist(this);
    }
}

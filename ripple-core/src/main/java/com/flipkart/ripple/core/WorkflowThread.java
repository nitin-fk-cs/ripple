package com.flipkart.ripple.core;

import com.flipkart.ripple.client.dto.Entity;

import java.util.List;

/**
 * Created by mayank on 05/07/17.
 */
public class WorkflowThread<T> {

    private String id;
    private final Workflow workflow;
    private final WorkflowThreadNode workflowThreadNode;
    private List<TaskNode> runningTasks;
    private List<WorkflowThread> childWorkflowThreads;
    private WorkflowThreadStatus workflowThreadStatus;
    private Entity<T> workflowThreadData;

    public WorkflowThread(Workflow workflow, WorkflowThreadNode workflowThreadNode) {
        this.workflow = workflow;
        this.workflowThreadNode = workflowThreadNode;
    }

    public enum WorkflowThreadStatus{}

    public Workflow getWorkflow() {
        return workflow;
    }

    public WorkflowThreadNode getWorkflowThreadNode() {
        return workflowThreadNode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Entity<T> getWorkflowThreadData() {
        return workflowThreadData;
    }

    public void setWorkflowThreadData(Entity<T> workflowThreadData) {
        this.workflowThreadData = workflowThreadData;
    }
}

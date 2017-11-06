package com.flipkart.ripple.core;

import com.flipkart.ripple.client.dto.Entity;
import com.flipkart.ripple.core.meta.WorkflowMeta;

/**
 * Created by mayank on 05/07/17.
 */
public class Workflow<W> {

    private WorkflowMeta workflowMeta;
    private WorkflowThread startThread;
    private String id;
    private final Entity<W> entity;

    public Workflow(Entity<W> entity) {
        this.entity = entity;
    }

    public WorkflowMeta getWorkflowMeta() {
        return workflowMeta;
    }

    public void setWorkflowMeta(WorkflowMeta workflowMeta) {
        this.workflowMeta = workflowMeta;
    }

    public WorkflowThread getStartThread() {
        return startThread;
    }

    public void setStartThread(WorkflowThread startThread) {
        this.startThread = startThread;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Entity<W> getEntity() {
        return entity;
    }

    public W getData() {
        return entity.getData();
    }

}

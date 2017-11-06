package com.flipkart.ripple.core;

import com.flipkart.ripple.client.dto.Entity;
import com.flipkart.ripple.core.meta.TaskMetaData;


/**
 * Created by mayank on 05/07/17.
 */
public abstract class Task {

    private String id;
    private final TaskMetaData taskMetaData;

    protected abstract Entity getInputParam(String key);
    protected abstract void addInputParam(String key, Entity entity);
    protected abstract Entity getOutputParam(String key);
    protected abstract void addOutputParam(String key, Entity entity);

    protected Task(TaskMetaData taskMetaData) {
        this.taskMetaData = taskMetaData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

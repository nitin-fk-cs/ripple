package com.flipkart.ripple.core;

import com.flipkart.dsl.ExecutionContext;
import com.flipkart.ripple.client.dto.Entity;
import com.flipkart.ripple.core.meta.WorkflowMeta;

import java.util.List;

/**
 * Created by mayank on 10/07/17.
 */

// Responsibilities ???
public interface WorkflowOrchestrator {

    <T> Workflow<T> start(WorkflowMeta workflowMeta, Entity<T> entity);
    List<Task> onComplete(Task task, ExecutionContext context);
    List<Task> onFailure(Task task);
}


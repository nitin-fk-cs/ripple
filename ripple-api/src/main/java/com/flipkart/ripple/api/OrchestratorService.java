package com.flipkart.ripple.api;

import com.flipkart.ripple.client.dto.WorkflowCreateRequest;
import com.flipkart.ripple.client.dto.WorkflowResponse;

/**
 * Created by mayank on 27/08/17.
 */
public interface OrchestratorService {
    <T> WorkflowResponse startWorkflow(WorkflowCreateRequest workflowMetaName);
    <T> WorkflowResponse updateWorkflow(WorkflowCreateRequest workflowMetaName);
}

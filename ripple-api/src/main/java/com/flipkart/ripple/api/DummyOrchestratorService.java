package com.flipkart.ripple.api;

import com.flipkart.ripple.client.dto.WorkflowCreateRequest;
import com.flipkart.ripple.client.dto.WorkflowResponse;
import com.google.inject.Singleton;

/**
 * Created by mayank on 29/08/17.
 */
@Singleton
public class DummyOrchestratorService implements OrchestratorService {
    @Override
    public <T> WorkflowResponse startWorkflow(WorkflowCreateRequest workflowMetaName) {
        return null;
    }

    @Override
    public <T> WorkflowResponse updateWorkflow(WorkflowCreateRequest workflowMetaName) {
        return null;
    }
}

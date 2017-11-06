package com.flipkart.ripple.core.meta;

/**
 * Created by mayank on 05/07/17.
 */
public class WorkflowMeta {

    private String name;

    private WorkflowThreadMetaNode startWorkflowThreadMetaNode;

    public String getName() {
        return name;
    }

    public WorkflowThreadMetaNode getStartWorkflowThreadMetaNode() {
        return startWorkflowThreadMetaNode;
    }
}

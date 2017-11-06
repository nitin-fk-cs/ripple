package com.flipkart.ripple.core;

import com.flipkart.ripple.core.meta.WorkflowThreadMetaNode;

import java.util.List;

/**
 * Created by mayank on 08/08/17.
 */
public class WorkflowThreadNode extends Node<WorkflowThreadMetaNode> {

    private WorkflowThread workflowThread;

    public WorkflowThreadNode(WorkflowThreadMetaNode metaNode, List<Node> parentNodes) {
        super(metaNode, parentNodes);
    }

    public WorkflowThread getWorkflowThread() {
        return workflowThread;
    }

    public void setWorkflowThread(WorkflowThread workflowThread) {
        this.workflowThread = workflowThread;
    }
}

package com.flipkart.ripple.core;

import com.flipkart.ripple.core.meta.MetaNode;

/**
 * Created by mayank on 09/08/17.
 */
public interface WorkflowNodeFactory {
    Node createNode(MetaNode metaNode, Workflow workflow, Node parentNode);
}

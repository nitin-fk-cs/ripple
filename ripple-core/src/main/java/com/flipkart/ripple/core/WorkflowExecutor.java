package com.flipkart.ripple.core;

import java.util.List;

/**
 * Created by mayank on 06/07/17.
 */
// Responsibilities ???
public interface WorkflowExecutor {

    Node start(Workflow workflow);
    List<Node> complete(Node node, Workflow workflow);
}

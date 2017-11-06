package com.flipkart.ripple.core;

import com.flipkart.dsl.ExecutionContext;
import com.flipkart.ripple.core.meta.MetaNode;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by mayank on 07/08/17.
 */
public abstract class Node<T extends MetaNode> {

    private String id;
    private final T metaNode;
    private final List<Node> parentNodes;
    private List<Node> nextNodes = Lists.newArrayList();

    public void execute(ExecutionContext context) {}

    public Node(T metaNode, List<Node> parentNodes) {
        this.metaNode = metaNode;
        this.parentNodes = parentNodes;
    }

    public T getMetaNode() {
        return metaNode;
    }

    public List<Node> getNextNodes() {
        return nextNodes;
    }

    public List<Node> getParentNode() {
        return parentNodes;
    }

    public void addNextNode(Node node){
        nextNodes.add(node);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

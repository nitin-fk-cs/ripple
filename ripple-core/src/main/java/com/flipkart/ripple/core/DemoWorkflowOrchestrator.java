package com.flipkart.ripple.core;

import com.flipkart.dao.TaskNodeDAO;
import com.flipkart.dsl.ExecutionContext;
import com.flipkart.dsl.WorkflowNodeExecutionContext;
import com.flipkart.ripple.client.dto.Entity;
import com.flipkart.ripple.core.meta.WorkflowMeta;
import com.flipkart.ripple.core.meta.WorkflowThreadMetaNode;
import com.google.inject.Inject;

import java.util.List;

/**
 * Created by mayank on 03/08/17.
 */
public class DemoWorkflowOrchestrator implements WorkflowOrchestrator {

    private final WorkflowExecutor workflowExecutor;
    private final EntityBuilderRegistry entityBuilderRegistry;
    private final TaskNodeDAO taskNodeDAO;

    @Inject
    public DemoWorkflowOrchestrator(WorkflowExecutor workflowExecutor, EntityBuilderRegistry entityBuilderRegistry, TaskNodeDAO taskNodeDAO) {

        this.workflowExecutor = workflowExecutor;
        this.entityBuilderRegistry = entityBuilderRegistry;
        this.taskNodeDAO = taskNodeDAO;
    }

    @Override
    public List<Task> onComplete(Task task, ExecutionContext executionContext) {
        TaskNode taskNode = taskNodeDAO.findTaskNodeByTask(task);
        List<Node> nextNodes = workflowExecutor.complete(taskNode, taskNode.getWorkflowThread().getWorkflow());
        for (Node nextNode : nextNodes) {
            nextNode.execute(executionContext);
        }
        return null;
    }

    @Override
    public List<Task> onFailure(Task task) {
        return null;
    }

    @Override
    public <W> Workflow<W> start(WorkflowMeta workflowMeta, Entity<W> entity) {
        Workflow<W> workflow = createWorkFlow(workflowMeta,entity);
        WorkflowThreadNode workflowThreadNode = startWorkflowThread(workflow);
        WorkflowThread workflowThread = processWorkflowThread(workflow, workflowThreadNode);
        workflow.setStartThread(workflowThread);
        List<Node> nextNodes = workflowExecutor.complete(workflowThreadNode, workflow);
        ExecutionContext executionContext = new WorkflowNodeExecutionContext();
        workflowThreadNode.execute(executionContext);
        return workflow;
    }

    private <W>WorkflowThreadNode startWorkflowThread(Workflow<W> workflow) {
        Node startNode = workflowExecutor.start(workflow);
        if(!(startNode instanceof WorkflowThreadNode)){
            throw new IllegalArgumentException("Something wrong with workflow configuration. Workflow start node should always be a workflow thread start node.");
        }

        return initializeWorkflowThreadNode((WorkflowThreadNode) startNode, workflow);
    }

    private <W>WorkflowThreadNode initializeWorkflowThreadNode(WorkflowThreadNode workflowThreadNode, Workflow<W> workflow) {

        WorkflowThread workflowThread = new WorkflowThread(workflow, workflowThreadNode);
        setWorkflowThreadEntity(workflow, workflowThread);
        workflowThreadNode.setWorkflowThread(workflowThread);
        return workflowThreadNode;
    }

    private <W> void setWorkflowThreadEntity(Workflow<W> workflow, WorkflowThread workflowThread) {
        WorkflowThreadMetaNode metaNode = workflowThread.getWorkflowThreadNode().getMetaNode();
        EntityBuilderType entityBuilderType = metaNode.getEntityBuilderType();
        EntityBuilder entityBuilder = entityBuilderRegistry.get(entityBuilderType);
        Entity entity = entityBuilder.build(workflow, workflowThread.getWorkflowThreadNode(), entityBuilderType);
        workflowThread.setWorkflowThreadData(entity);
    }


    private<W> Workflow<W> createWorkFlow(WorkflowMeta workflowMeta, Entity<W> entity) {
        Workflow<W> workflow = new Workflow<W>(entity);
        workflow.setWorkflowMeta(workflowMeta);
        return workflow;
    }

    private WorkflowThread processWorkflowThread(Workflow workflow, WorkflowThreadNode workflowThreadNode) {
        WorkflowThread workflowThread = new WorkflowThread(workflow, workflowThreadNode);
        workflowThreadNode.setWorkflowThread(workflowThread);
        return workflowThread;
    }

}

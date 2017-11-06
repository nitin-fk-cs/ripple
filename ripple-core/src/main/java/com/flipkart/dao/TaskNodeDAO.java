package com.flipkart.dao;

import com.flipkart.ripple.core.Task;
import com.flipkart.ripple.core.TaskNode;

/**
 * Created by nitin.s on 02/11/17.
 */
public interface TaskNodeDAO {
    TaskNode findTaskNodeByTask(Task task);
    TaskNode persist(TaskNode taskNode);
}

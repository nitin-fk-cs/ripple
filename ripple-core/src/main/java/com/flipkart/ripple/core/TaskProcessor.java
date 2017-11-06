package com.flipkart.ripple.core;

/**
 * Created by mayank on 10/07/17.
 */
public interface TaskProcessor {
    TaskStatus process(Task task, Workflow workflow);
}

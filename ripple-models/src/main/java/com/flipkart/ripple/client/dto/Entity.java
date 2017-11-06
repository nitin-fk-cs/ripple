package com.flipkart.ripple.client.dto;

/**
 * Created by mayank on 17/07/17.
 */
public class Entity<T> {

    private final T data;

    public Entity(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

}

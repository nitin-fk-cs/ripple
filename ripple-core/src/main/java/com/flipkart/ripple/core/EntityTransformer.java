package com.flipkart.ripple.core;

import com.flipkart.ripple.client.dto.Entity;

import java.util.Map;

/**
 * Created by mayank on 17/07/17.
 */
public interface EntityTransformer {
    Entity transform(Map<String, Entity> entityMap);
}

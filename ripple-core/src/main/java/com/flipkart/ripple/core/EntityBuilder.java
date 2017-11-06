package com.flipkart.ripple.core;

import com.flipkart.ripple.client.dto.Entity;

/**
 * Created by mayank on 26/10/17.
 */
public interface EntityBuilder<W> {

    Entity build(Workflow<W> workflow, Node node, EntityBuilderType entityBuilderType);
}

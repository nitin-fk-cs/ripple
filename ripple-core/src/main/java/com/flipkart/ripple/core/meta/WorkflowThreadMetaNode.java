package com.flipkart.ripple.core.meta;

import com.flipkart.ripple.core.EntityBuilderType;
import lombok.Data;

/**
 * Created by mayank on 05/07/17.
 */
@Data
public class WorkflowThreadMetaNode extends MetaNode {

    private WorkflowThreadMetaData workflowThreadMetaData;
    private EntityBuilderType entityBuilderType;
}

package com.flipkart.dsl;

/**
 * Created by gaurav.ss on 13/08/17.
 */


//TASK STATE MACHINE

import com.flipkart.ripple.core.Node;

/**
                INIT
                  |
                  |
                IN_PROGRESS ----
                 |     |        |
                 |     |        |
                 |     |        |
                 |      --------WAIT
                 |                |
             -------------        | Timeout
            |             |       |
            SUCCESS    FAILURE----


 */

public interface State {
    public void performOperation(Node node, ExecutionContext context);
}

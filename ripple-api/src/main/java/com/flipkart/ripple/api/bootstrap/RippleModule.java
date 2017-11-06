package com.flipkart.ripple.api.bootstrap;

import com.flipkart.ripple.api.DummyOrchestratorService;
import com.flipkart.ripple.api.OrchestratorService;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Created by mayank on 29/08/17.
 */
public class RippleModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(OrchestratorService.class).to(DummyOrchestratorService.class);
    }
}

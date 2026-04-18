package com.bank.payments.infrastructure.resilience;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class RetryConfig {

    @Retry(
            maxRetries = 3,
            delay = 1000,
            jitter = 200
    )
    public void execute(Runnable action) {
        action.run();
    }
}
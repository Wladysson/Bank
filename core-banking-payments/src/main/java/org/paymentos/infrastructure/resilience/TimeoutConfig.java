package com.bank.payments.infrastructure.resilience;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.faulttolerance.Timeout;

@ApplicationScoped
public class TimeoutConfig {

    @Timeout(2000) // 2 segundos
    public void execute(Runnable action) {
        action.run();
    }
}
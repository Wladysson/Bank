package com.bank.payments.infrastructure.resilience;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;

@ApplicationScoped
public class CircuitBreakerConfig {

    @CircuitBreaker(
            requestVolumeThreshold = 5,     // após 5 chamadas
            failureRatio = 0.5,             // 50% falha → abre circuito
            delay = 5000                   // espera 5s pra tentar de novo
    )
    public void execute(Runnable action) {
        action.run();
    }
}
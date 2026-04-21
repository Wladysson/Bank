package com.bank.payments.interfaces.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import jakarta.enterprise.context.ApplicationScoped;

@Readiness
@ApplicationScoped
public class ReadinessCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {

        // aqui você pode validar:
        // - banco
        // - kafka
        // - serviços externos

        return HealthCheckResponse.up("payments-readiness");
    }
}
package com.bank.payments.infrastructure.integration.gateway;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

@ApplicationScoped
public class GatewaySelector {

    @Inject
    Instance<PaymentGateway> gateways;

    public PaymentGateway select() {
        return gateways.stream()
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Nenhum gateway disponível"));
    }
}
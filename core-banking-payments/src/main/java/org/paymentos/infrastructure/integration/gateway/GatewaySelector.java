package com.bank.payments.infrastructure.integration.gateway;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GatewaySelector {

    @Inject
    List<PaymentGateway> gateways;

    public PaymentGateway select() {
        // simples por enquanto (depois melhora com regra)
        return gateways.stream().findFirst()
                .orElseThrow(() -> new IllegalStateException("Nenhum gateway disponível"));
    }
}
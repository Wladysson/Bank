package com.bank.payments.infrastructure.integration.gateway.adapters;

import com.bank.payments.domain.model.Payment;
import com.bank.payments.infrastructure.integration.gateway.PaymentGateway;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CieloAdapter implements PaymentGateway {

    @Override
    public boolean process(Payment payment) {
        System.out.println("Processando pagamento via Cielo: " + payment.getId());
        return true;
    }

    @Override
    public String getName() {
        return "CIELO";
    }
}
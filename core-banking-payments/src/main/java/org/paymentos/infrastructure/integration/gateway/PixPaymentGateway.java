package com.bank.payments.infrastructure.integration.gateway;

import com.bank.payments.domain.model.Payment;
import com.bank.payments.infrastructure.integration.gateway.PaymentGateway;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PixPaymentGateway implements PaymentGateway {

    @Override
    public boolean process(Payment payment) {
        return true;
    }

    @Override
    public String getName() {
        return "PIX";
    }
}
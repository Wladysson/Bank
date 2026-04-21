package com.bank.payments.infrastructure.integration.gateway;

import com.bank.payments.domain.model.Payment;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DefaultPaymentGateway implements PaymentGateway {

    @Override
    public boolean process(Payment payment) {
        System.out.println("Processando pagamento no gateway DEFAULT");
        return true;
    }

    @Override
    public String getName() {
        return "DEFAULT";
    }
}
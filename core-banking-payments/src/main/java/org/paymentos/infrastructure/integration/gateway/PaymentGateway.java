package com.bank.payments.infrastructure.integration.gateway;

import com.bank.payments.domain.model.Payment;
import jakarta.enterprise.context.ApplicationScoped;

public interface PaymentGateway {

    boolean process(Payment payment);

    String getName();
}
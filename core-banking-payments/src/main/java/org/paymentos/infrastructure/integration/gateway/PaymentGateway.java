package com.bank.payments.infrastructure.integration.gateway;

import com.bank.payments.domain.model.Payment;

public interface PaymentGateway {

    boolean process(Payment payment);

    String getName();
}
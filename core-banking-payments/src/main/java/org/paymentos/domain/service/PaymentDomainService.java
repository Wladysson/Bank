package com.bank.payments.domain.service;

import com.bank.payments.domain.model.Payment;
import com.bank.payments.domain.model.PaymentStatus;

public class PaymentDomainService {

    public void process(Payment payment) {

        if (payment.getStatus() != PaymentStatus.CREATED) {
            throw new IllegalStateException("Pagamento nao pode ser processado");
        }

        payment.markAsProcessed();
    }

    public void authorize(Payment payment) {

        if (payment.getStatus() != PaymentStatus.PROCESSING) {
            throw new IllegalStateException("Pagamento nao pode ser autorizado");
        }

        payment.markAsAuthorized();
    }

    public void capture(Payment payment) {

        if (payment.getStatus() != PaymentStatus.AUTHORIZED) {
            throw new IllegalStateException("Pagamento nao pode ser capturado");
        }

        payment.markAsCaptured();
    }

    public void fail(Payment payment) {
        payment.markAsFailed();
    }
}
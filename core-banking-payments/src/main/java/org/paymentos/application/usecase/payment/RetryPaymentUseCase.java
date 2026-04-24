package com.bank.payments.application.usecase.payment;

import com.bank.payments.domain.model.Payment;
import com.bank.payments.domain.model.PaymentStatus;
import com.bank.payments.domain.repository.PaymentRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RetryPaymentUseCase {

    @Inject
    PaymentRepository repository;

    public Payment execute(String id) {

        Payment payment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        if (payment.getStatus() != PaymentStatus.FAILED) {
            throw new RuntimeException("Only FAILED payments can be retried");
        }

        payment.setStatus(PaymentStatus.PROCESSING);

        // aqui você poderia reenviar para Kafka/fila
        repository.update(payment);

        return payment;
    }
}
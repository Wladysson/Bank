package com.bank.payments.application.usecase.payment;

import com.bank.payments.domain.model.Payment;
import com.bank.payments.domain.model.PaymentStatus;
import com.bank.payments.domain.repository.PaymentRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ConfirmPaymentUseCase {

    @Inject
    PaymentRepository repository;

    public Payment execute(String id) {

        Payment payment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        if (payment.getStatus() != PaymentStatus.PROCESSING) {
            throw new RuntimeException("Only PROCESSING payments can be completed");
        }

        payment.setStatus(PaymentStatus.COMPLETED);

        // aqui você pode disparar ledger/evento
        repository.update(payment);

        return payment;
    }
}
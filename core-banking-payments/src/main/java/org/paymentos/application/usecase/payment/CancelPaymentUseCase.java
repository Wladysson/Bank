package com.bank.payments.application.usecase.payment;

import com.bank.payments.domain.model.Payment;
import com.bank.payments.domain.model.PaymentStatus;
import com.bank.payments.domain.repository.PaymentRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CancelPaymentUseCase {

    @Inject
    PaymentRepository repository;

    public Payment execute(String id) {

        Payment payment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        if (payment.getStatus() == PaymentStatus.COMPLETED) {
            throw new RuntimeException("Cannot cancel a completed payment");
        }

        if (payment.getStatus() == PaymentStatus.CANCELLED) {
            throw new RuntimeException("Payment already cancelled");
        }

        payment.setStatus(PaymentStatus.CANCELLED);

        repository.update(payment);

        return payment;
    }
}
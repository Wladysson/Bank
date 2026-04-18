package com.bank.payments.domain.repository;

import com.bank.payments.domain.model.Payment;

import java.util.Optional;

public interface PaymentRepository {

    void save(Payment payment);

    Optional<Payment> findById(String paymentId);

    Optional<Payment> findByExternalReference(String externalReference);

    void update(Payment payment);
}
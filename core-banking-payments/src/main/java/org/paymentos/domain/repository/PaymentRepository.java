package com.bank.payments.domain.repository;

import com.bank.payments.domain.model.Payment;
import com.bank.payments.domain.model.PaymentStatus;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

public interface PaymentRepository {

    void save(Payment payment);

    Optional<Payment> findById(String paymentId);

    Optional<Payment> findByExternalReference(String externalReference);

    List<Payment> findByStatus(PaymentStatus status, int limit);

    List<Payment> findProcessingOlderThan(LocalDateTime threshold);

    List<Payment> findWithFilters(
            String status,
            String userId,
            LocalDateTime from,
            LocalDateTime to
    );

    List<Payment> findAll();

    void update(Payment payment);
}
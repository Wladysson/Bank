package com.bank.payments.domain.model;

public enum PaymentStatus {
    CREATED,
    VALIDATED,
    PENDING,
    PROCESSING,
    AUTHORIZED,
    CAPTURED,
    COMPLETED,
    FAILED,
    REFUNDED,
    CHARGEBACK,
    CANCELLED
}
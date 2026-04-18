package com.bank.payments.domain.model;

public enum PaymentStatus {
    CREATED,
    VALIDATED,
    PROCESSING,
    AUTHORIZED,
    CAPTURED,
    FAILED,
    REFUNDED,
    CHARGEBACK
}
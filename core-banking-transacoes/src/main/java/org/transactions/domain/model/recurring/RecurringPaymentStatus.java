package com.bank.transactions.domain.model.recurring;

// Enum responsável pelos status da recorrência
public enum RecurringPaymentStatus {

    ACTIVE,
    PAUSED,
    CANCELLED,
    COMPLETED,
    FAILED
}
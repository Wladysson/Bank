package com.bank.transactions.domain.model.common;

// Enum responsável pelos status da transação
public enum TransactionStatus {

    PENDING,
    PROCESSING,
    COMPLETED,
    FAILED,
    CANCELLED,
    REFUNDED
}
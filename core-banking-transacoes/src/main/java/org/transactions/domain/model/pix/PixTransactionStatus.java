package com.bank.transactions.domain.model.pix;

// Enum responsável pelos status da transação PIX
public enum PixTransactionStatus {

    CREATED,
    PROCESSING,
    SETTLED,
    FAILED,
    REFUNDED,
    CANCELLED
}
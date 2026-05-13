package com.bank.transactions.domain.model.common;

// Enum responsável pelos tipos transacionais
public enum TransactionType {

    PIX,
    INTERNAL_TRANSFER,
    TED,
    DOC,
    SCHEDULED,
    RECURRING,
    INTERNATIONAL
}
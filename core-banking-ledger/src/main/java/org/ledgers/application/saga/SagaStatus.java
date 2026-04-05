package com.bank.ledger.application.saga;

public enum SagaStatus {
    STARTED,
    JOURNAL_POSTED,
    COMPLETED,
    COMPENSATED,
    FAILED
}
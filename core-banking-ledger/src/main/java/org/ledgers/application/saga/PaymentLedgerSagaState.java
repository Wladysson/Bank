package com.bank.ledger.application.saga;

import java.util.UUID;

public class PaymentLedgerSagaState {

    private UUID sagaId;
    private UUID paymentId;
    private boolean journalPosted;
    private boolean completed;
    private boolean failed;

    public PaymentLedgerSagaState(UUID sagaId, UUID paymentId) {
        this.sagaId = sagaId;
        this.paymentId = paymentId;
    }

    public UUID getSagaId() {
        return sagaId;
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public boolean isJournalPosted() {
        return journalPosted;
    }

    public void markJournalPosted() {
        this.journalPosted = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public boolean isFailed() {
        return failed;
    }

    public void markFailed() {
        this.failed = true;
    }
}
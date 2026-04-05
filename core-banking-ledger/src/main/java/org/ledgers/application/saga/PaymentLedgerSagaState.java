package com.bank.ledger.application.saga;

import com.bank.ledger.domain.model.LedgerEntry;
import java.util.UUID;
import java.util.List;

public class PaymentLedgerSagaState {

    private final UUID paymentId;
    private SagaStatus status;

    private List<LedgerEntry> entries;

    public List<LedgerEntry> getEntries() {
        return entries;
    }

    public PaymentLedgerSagaState(UUID paymentId, List<LedgerEntry> entries) {
        this.paymentId = paymentId;
        this.entries = entries;
        this.status = SagaStatus.STARTED;
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public SagaStatus getStatus() {
        return status;
    }

    public void markJournalPosted() {
        this.status = SagaStatus.JOURNAL_POSTED;
    }

    public void markCompleted() {
        this.status = SagaStatus.COMPLETED;
    }

    public void markCompensated() {
        this.status = SagaStatus.COMPENSATED;
    }

    public void markFailed() {
        this.status = SagaStatus.FAILED;
    }

    public boolean isCompensated() {
        return this.status == SagaStatus.COMPENSATED;
    }
}
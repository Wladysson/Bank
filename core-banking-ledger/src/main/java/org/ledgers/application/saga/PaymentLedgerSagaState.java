package com.bank.ledger.application.saga;

import com.bank.ledger.domain.model.LedgerEntry;
import java.util.UUID;
import java.util.List;
import java.math.BigDecimal;

public class PaymentLedgerSagaState {

    private final UUID paymentId;
    private SagaStatus status;
    private final BigDecimal amount;
    private List<LedgerEntry> entries;

    private UUID originalDebitAccount;
    private UUID originalCreditAccount;

    public List<LedgerEntry> getEntries() {
        return entries;
    }

    public PaymentLedgerSagaState(UUID paymentId, BigDecimal amount, List<LedgerEntry> entries, UUID originalDebitAccount, UUID originalCreditAccount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.entries = entries;
        this.status = SagaStatus.STARTED;
        this.originalDebitAccount = originalDebitAccount;
        this.originalCreditAccount = originalCreditAccount;
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

    public boolean isCompensated() { return this.status == SagaStatus.COMPENSATED; }

    public BigDecimal getAmount() { return amount; }

    public UUID getOriginalDebitAccount() { return originalDebitAccount; }

    public UUID getOriginalCreditAccount() { return originalCreditAccount; }
}
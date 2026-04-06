package com.bank.ledger.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class JournalEntryLine {

    private final UUID accountId;
    private final BigDecimal amount;
    private final EntryType type;

    public JournalEntryLine(UUID accountId, BigDecimal amount, EntryType type) {
        this.accountId = accountId;
        this.amount = amount;
        this.type = type;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public EntryType getType() {
        return type;
    }

    public boolean isDebit() {
        return type == EntryType.DEBIT;
    }

    public boolean isCredit() {
        return type == EntryType.CREDIT;
    }
}
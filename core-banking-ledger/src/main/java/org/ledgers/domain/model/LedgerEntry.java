package com.bank.ledger.domain.model;

import java.time.Instant;
import java.util.UUID;

public class LedgerEntry {
    private final UUID id;
    private final AccountReference account;
    private final Money amount;
    private final Instant createdAt;

    public LedgerEntry(AccountReference account, Money amount) {
        this.id = UUID.randomUUID();
        this.account = account;
        this.amount = amount;
        this.createdAt = Instant.now();
    }

    public UUID getId() {
        return id;
    }

    public AccountReference getAccount() {
        return account;
    }

    public Money getAmount() {
        return amount;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
package com.bank.ledger.domain.model;

import java.util.UUID;

public class AccountReference {
    private final UUID accountId;
    private final LedgerAccountType accountType;

    public AccountReference(UUID accountId, LedgerAccountType accountType) {
        this.accountId = accountId;
        this.accountType = accountType;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public LedgerAccountType getAccountType() {
        return accountType;
    }
}
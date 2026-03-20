package com.bank.account.domain.model;

import java.util.UUID;

public class AccountHolder {

    private final UUID holderId;
    private final boolean primary;

    public AccountHolder(UUID holderId, boolean primary) {
        this.holderId = holderId;
        this.primary = primary;
    }

    public UUID getHolderId() { return holderId; }
    public boolean isPrimary() { return primary; }
}
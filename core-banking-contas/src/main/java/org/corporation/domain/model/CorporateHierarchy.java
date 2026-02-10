package com.bank.account.domain.model;

import java.util.UUID;

public class CorporateHierarchy {

    private final UUID parentAccountId;
    private final UUID childAccountId;
    private final int level;

    public CorporateHierarchy(UUID parentAccountId, UUID childAccountId, int level) {
        this.parentAccountId = parentAccountId;
        this.childAccountId = childAccountId;
        this.level = level;
    }

    public UUID getParentAccountId() { return parentAccountId; }
    public UUID getChildAccountId() { return childAccountId; }
    public int getLevel() { return level; }
}
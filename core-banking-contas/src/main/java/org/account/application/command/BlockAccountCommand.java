package com.bank.account.application.command;

import java.util.UUID;

public class BlockAccountCommand {

    private UUID accountId;
    private String blockReason;

    public BlockAccountCommand() {
    }

    public BlockAccountCommand(UUID accountId, String blockReason) {
        this.accountId = accountId;
        this.blockReason = blockReason;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public String getBlockReason() {
        return blockReason;
    }
}
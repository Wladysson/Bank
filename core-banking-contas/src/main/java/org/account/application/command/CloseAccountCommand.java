package com.bank.account.application.command;

import java.util.UUID;

public class CloseAccountCommand {

    private UUID accountId;
    private String reason;

    public CloseAccountCommand() {
    }

    public CloseAccountCommand(UUID accountId, String reason) {
        this.accountId = accountId;
        this.reason = reason;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public String getReason() {
        return reason;
    }
}
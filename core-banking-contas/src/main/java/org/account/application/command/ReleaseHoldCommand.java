package com.bank.account.application.command;

import java.util.UUID;

public class ReleaseHoldCommand {

    private UUID holdId;

    public ReleaseHoldCommand() {
    }

    public ReleaseHoldCommand(UUID holdId) {
        this.holdId = holdId;
    }

    public UUID getHoldId() {
        return holdId;
    }
}
package com.bank.account.application.command;

public class ReleaseHoldCommand {

    private String holdId;

    private String reason;

    private String releasedBy;

    private String operationId;

    public ReleaseHoldCommand() {
    }

    public ReleaseHoldCommand(String holdId, String reason, String releasedBy, String operationId) {
        this.holdId = holdId;
        this.reason = reason;
        this.releasedBy = releasedBy;
        this.operationId = operationId;
    }

    public String getHoldId() {
        return holdId;
    }

    public String getReason() {
        return reason;
    }

    public String getReleasedBy() {
        return releasedBy;
    }

    public String getOperationId() {
        return operationId;
    }
}
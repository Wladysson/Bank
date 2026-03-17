package com.bank.account.application.command;

import java.math.BigDecimal;
import java.util.UUID;

public class ReserveBalanceCommand {

    private UUID accountId;
    private BigDecimal amount;
    private String reason;
    private UUID referenceId;

    public ReserveBalanceCommand() {
    }

    public ReserveBalanceCommand(UUID accountId, BigDecimal amount, String reason, UUID referenceId) {
        this.accountId = accountId;
        this.amount = amount;
        this.reason = reason;
        this.referenceId = referenceId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getReason() {
        return reason;
    }

    public UUID getReferenceId() {
        return referenceId;
    }
}
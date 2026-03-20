package com.bank.account.application.command;

import java.math.BigDecimal;
import java.util.UUID;

public class ConfigureLimitCommand {

    private UUID accountId;

    private BigDecimal pixDailyLimit;
    private BigDecimal withdrawDailyLimit;
    private BigDecimal tedDailyLimit;

    public ConfigureLimitCommand() {
    }

    public ConfigureLimitCommand(
            UUID accountId,
            BigDecimal pixDailyLimit,
            BigDecimal withdrawDailyLimit,
            BigDecimal tedDailyLimit) {

        this.accountId = accountId;
        this.pixDailyLimit = pixDailyLimit;
        this.withdrawDailyLimit = withdrawDailyLimit;
        this.tedDailyLimit = tedDailyLimit;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public BigDecimal getPixDailyLimit() {
        return pixDailyLimit;
    }

    public BigDecimal getWithdrawDailyLimit() {
        return withdrawDailyLimit;
    }

    public BigDecimal getTedDailyLimit() {
        return tedDailyLimit;
    }
}
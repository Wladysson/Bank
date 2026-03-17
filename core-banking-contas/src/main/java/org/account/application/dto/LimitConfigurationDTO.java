package com.bank.account.application.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class LimitConfigurationDTO {

    private UUID accountId;

    private BigDecimal pixDailyLimit;
    private BigDecimal withdrawDailyLimit;
    private BigDecimal tedDailyLimit;

    public LimitConfigurationDTO() {
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getPixDailyLimit() {
        return pixDailyLimit;
    }

    public void setPixDailyLimit(BigDecimal pixDailyLimit) {
        this.pixDailyLimit = pixDailyLimit;
    }

    public BigDecimal getWithdrawDailyLimit() {
        return withdrawDailyLimit;
    }

    public void setWithdrawDailyLimit(BigDecimal withdrawDailyLimit) {
        this.withdrawDailyLimit = withdrawDailyLimit;
    }

    public BigDecimal getTedDailyLimit() {
        return tedDailyLimit;
    }

    public void setTedDailyLimit(BigDecimal tedDailyLimit) {
        this.tedDailyLimit = tedDailyLimit;
    }
}
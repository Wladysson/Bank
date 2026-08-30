package com.bank.account.overdraft.domain.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OverdraftLimitGrantedEvent {

    private final String accountId;
    private final String contractId;
    private final BigDecimal grantedAmount;
    private final String riskProfile;
    private final LocalDateTime occurredAt;

    public OverdraftLimitGrantedEvent(
            String accountId,
            String contractId,
            BigDecimal grantedAmount,
            String riskProfile
    ) {
        this.accountId = accountId;
        this.contractId = contractId;
        this.grantedAmount = grantedAmount;
        this.riskProfile = riskProfile;
        this.occurredAt = LocalDateTime.now();
    }

    public String getAccountId() {
        return accountId;
    }

    public String getContractId() {
        return contractId;
    }

    public BigDecimal getGrantedAmount() {
        return grantedAmount;
    }

    public String getRiskProfile() {
        return riskProfile;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}
package com.bank.account.overdraft.domain.exception;

import java.math.BigDecimal;

public class OverdraftLimitExceededException extends RuntimeException {

    private final BigDecimal requestedAmount;
    private final BigDecimal availableAmount;

    public OverdraftLimitExceededException(
            BigDecimal requestedAmount,
            BigDecimal availableAmount
    ) {
        super(
                "Overdraft limit exceeded. "
                        + "Requested: " + requestedAmount
                        + ", Available: " + availableAmount
        );

        this.requestedAmount = requestedAmount;
        this.availableAmount = availableAmount;
    }

    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }

    public BigDecimal getAvailableAmount() {
        return availableAmount;
    }
}
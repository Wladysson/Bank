package com.bank.account.application.command;

import java.math.BigDecimal;
import java.util.UUID;

public class OpenAccountCommand {

    private UUID customerId;
    private String accountType;
    private String currency;
    private BigDecimal initialDeposit;

    public OpenAccountCommand() {
    }

    public OpenAccountCommand(UUID customerId, String accountType, String currency, BigDecimal initialDeposit) {
        this.customerId = customerId;
        this.accountType = accountType;
        this.currency = currency;
        this.initialDeposit = initialDeposit;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getInitialDeposit() {
        return initialDeposit;
    }
}


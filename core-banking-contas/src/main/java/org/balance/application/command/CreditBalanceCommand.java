package com.bank.account.balance.application.command;

import java.math.BigDecimal;

public class CreditBalanceCommand {

    private final String accountId; // conta que receberá o crédito

    private final BigDecimal amount; // valor a ser creditado

    private final String operationId; // identificador único da operação

    private final String description; // descrição da movimentação

    private final String channel; // canal de origem da operação

    public CreditBalanceCommand(
            String accountId,
            BigDecimal amount,
            String operationId,
            String description,
            String channel
    ) {

        this.accountId = accountId;
        this.amount = amount;
        this.operationId = operationId;
        this.description = description;
        this.channel = channel;
    }

    public String getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getOperationId() {
        return operationId;
    }

    public String getDescription() {
        return description;
    }

    public String getChannel() {
        return channel;
    }
}
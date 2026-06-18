package com.bank.account.balance.domain.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BalanceCreditedEvent {

    private final String accountId; // conta que recebeu o crédito

    private final BigDecimal amount; // valor creditado

    private final String operationId; // identificador da operação

    private final String description; // descrição da movimentação

    private final LocalDateTime occurredAt; // data do evento

    public BalanceCreditedEvent(
            String accountId,
            BigDecimal amount,
            String operationId,
            String description
    ) {

        this.accountId = accountId;
        this.amount = amount;
        this.operationId = operationId;
        this.description = description;
        this.occurredAt = LocalDateTime.now(); // registra momento do crédito
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

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}
package com.bank.account.overdraft.domain.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OverdraftUsedEvent {

    private final String accountId; // conta que utilizou o cheque especial
    private final String contractId; // contrato de cheque especial utilizado
    private final BigDecimal amount; // valor utilizado
    private final BigDecimal remainingAmount; // limite restante após utilização
    private final String operationId; // operação responsável pelo consumo
    private final LocalDateTime occurredAt; // momento da utilização

    public OverdraftUsedEvent(
            String accountId,
            String contractId,
            BigDecimal amount,
            BigDecimal remainingAmount,
            String operationId
    ) {
        this.accountId = accountId;
        this.contractId = contractId;
        this.amount = amount;
        this.remainingAmount = remainingAmount;
        this.operationId = operationId;
        this.occurredAt = LocalDateTime.now(); // registra momento do evento
    }

    public String getAccountId() {
        return accountId;
    }

    public String getContractId() {
        return contractId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getRemainingAmount() {
        return remainingAmount;
    }

    public String getOperationId() {
        return operationId;
    }

    public LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}
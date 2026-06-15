package com.bank.account.hold.application.command;

import com.bank.account.hold.domain.model.HoldReason;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateHoldCommand {

    private final String accountId; // conta que terá valor reservado

    private final BigDecimal amount; // valor a ser reservado

    private final HoldReason reason; // motivo da reserva

    private final LocalDateTime expirationDate; // data de expiração da reserva

    private final String operationId; // id de rastreio da operação externa

    public CreateHoldCommand(
            String accountId,
            BigDecimal amount,
            HoldReason reason,
            LocalDateTime expirationDate,
            String operationId
    ) {
        this.accountId = accountId;
        this.amount = amount;
        this.reason = reason;
        this.expirationDate = expirationDate;
        this.operationId = operationId;
    }

    public String getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public HoldReason getReason() {
        return reason;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public String getOperationId() {
        return operationId;
    }
}
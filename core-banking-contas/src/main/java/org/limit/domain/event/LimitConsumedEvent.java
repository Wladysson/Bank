package com.bank.account.limit.domain.event;

import com.bank.account.limit.domain.model.AccountChannel;
import com.bank.account.limit.domain.model.LimitType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LimitConsumedEvent {

    private final String accountId; // identificador da conta que consumiu o limite
    private final String limitId; // identificador do limite consumido
    private final LimitType limitType; // tipo de operação que consumiu o limite
    private final AccountChannel channel; // canal utilizado na operação
    private final BigDecimal consumedAmount; // valor consumido pela operação
    private final BigDecimal remainingAmount; // saldo restante do limite após o consumo
    private final String operationId; // identificador da operação responsável pelo consumo
    private final LocalDateTime occurredAt; // momento em que o consumo ocorreu

    public LimitConsumedEvent(
            String accountId,
            String limitId,
            LimitType limitType,
            AccountChannel channel,
            BigDecimal consumedAmount,
            BigDecimal remainingAmount,
            String operationId
    ) {
        this.accountId = accountId;
        this.limitId = limitId;
        this.limitType = limitType;
        this.channel = channel;
        this.consumedAmount = consumedAmount;
        this.remainingAmount = remainingAmount;
        this.operationId = operationId;
        this.occurredAt = LocalDateTime.now(); // registra o momento do consumo
    }

    public String getAccountId() {
        return accountId;
    }

    public String getLimitId() {
        return limitId;
    }

    public LimitType getLimitType() {
        return limitType;
    }

    public AccountChannel getChannel() {
        return channel;
    }

    public BigDecimal getConsumedAmount() {
        return consumedAmount;
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
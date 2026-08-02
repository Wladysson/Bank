package com.bank.account.limit.application.dto;

import com.bank.account.limit.domain.model.AccountChannel;
import com.bank.account.limit.domain.model.LimitType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LimitConsumptionDTO {

    private String limitId; // identificador do limite consumido
    private String accountId; // conta responsável pelo consumo
    private LimitType limitType; // tipo de limite utilizado
    private AccountChannel channel; // canal utilizado na operação
    private BigDecimal consumedAmount; // valor consumido
    private BigDecimal remainingAmount; // valor restante após o consumo
    private String operationId; // identificador da operação relacionada
    private LocalDateTime consumedAt; // momento em que ocorreu o consumo

    public LimitConsumptionDTO() {
    }

    public LimitConsumptionDTO(
            String limitId,
            String accountId,
            LimitType limitType,
            AccountChannel channel,
            BigDecimal consumedAmount,
            BigDecimal remainingAmount,
            String operationId,
            LocalDateTime consumedAt
    ) {
        this.limitId = limitId;
        this.accountId = accountId;
        this.limitType = limitType;
        this.channel = channel;
        this.consumedAmount = consumedAmount;
        this.remainingAmount = remainingAmount;
        this.operationId = operationId;
        this.consumedAt = consumedAt;
    }

    public String getLimitId() {
        return limitId;
    }

    public void setLimitId(String limitId) {
        this.limitId = limitId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public LimitType getLimitType() {
        return limitType;
    }

    public void setLimitType(LimitType limitType) {
        this.limitType = limitType;
    }

    public AccountChannel getChannel() {
        return channel;
    }

    public void setChannel(AccountChannel channel) {
        this.channel = channel;
    }

    public BigDecimal getConsumedAmount() {
        return consumedAmount;
    }

    public void setConsumedAmount(BigDecimal consumedAmount) {
        this.consumedAmount = consumedAmount;
    }

    public BigDecimal getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(BigDecimal remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public LocalDateTime getConsumedAt() {
        return consumedAt;
    }

    public void setConsumedAt(LocalDateTime consumedAt) {
        this.consumedAt = consumedAt;
    }
}
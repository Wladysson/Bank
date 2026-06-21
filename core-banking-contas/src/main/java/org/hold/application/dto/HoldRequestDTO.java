package com.bank.account.hold.application.dto;

import com.bank.account.hold.domain.model.HoldReason;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HoldRequestDTO {

    private String accountId; // conta que receberá a reserva

    private BigDecimal amount; // valor a ser reservado

    private HoldReason reason; // motivo da reserva

    private LocalDateTime expirationDate; // data limite da reserva

    private String operationId; // identificador da operação de origem

    public HoldRequestDTO() {
    }

    public HoldRequestDTO(
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

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public HoldReason getReason() {
        return reason;
    }

    public void setReason(HoldReason reason) {
        this.reason = reason;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }
}
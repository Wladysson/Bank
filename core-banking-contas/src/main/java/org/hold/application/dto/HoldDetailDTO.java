package com.bank.account.hold.application.dto;

import com.bank.account.hold.domain.model.HoldReason;
import com.bank.account.hold.domain.model.HoldStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HoldDetailDTO {

    private String holdId; // identificador da reserva

    private String accountId; // identificador da conta

    private BigDecimal amount; // valor reservado

    private HoldReason reason; // motivo da reserva

    private HoldStatus status; // situação atual da reserva

    private String operationId; // operação que originou a reserva

    private String createdBy; // usuário ou sistema que criou a reserva

    private String releasedBy; // usuário ou sistema que liberou a reserva

    private LocalDateTime createdAt; // data de criação

    private LocalDateTime updatedAt; // data da última atualização

    private LocalDateTime expirationDate; // data prevista para expiração

    public HoldDetailDTO() {
    }

    public HoldDetailDTO(
            String holdId,
            String accountId,
            BigDecimal amount,
            HoldReason reason,
            HoldStatus status,
            String operationId,
            String createdBy,
            String releasedBy,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            LocalDateTime expirationDate
    ) {
        this.holdId = holdId;
        this.accountId = accountId;
        this.amount = amount;
        this.reason = reason;
        this.status = status;
        this.operationId = operationId;
        this.createdBy = createdBy;
        this.releasedBy = releasedBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.expirationDate = expirationDate;
    }

    public String getHoldId() {
        return holdId;
    }

    public void setHoldId(String holdId) {
        this.holdId = holdId;
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

    public HoldStatus getStatus() {
        return status;
    }

    public void setStatus(HoldStatus status) {
        this.status = status;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getReleasedBy() {
        return releasedBy;
    }

    public void setReleasedBy(String releasedBy) {
        this.releasedBy = releasedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }
}
package com.bank.account.hold.application.dto;

import com.bank.account.hold.domain.model.HoldReason;
import com.bank.account.hold.domain.model.HoldStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HoldResponseDTO {

    private String holdId; // identificador da reserva

    private String accountId; // conta associada ao hold

    private BigDecimal amount; // valor reservado

    private HoldReason reason; // motivo da reserva

    private HoldStatus status; // status atual do hold

    private LocalDateTime expirationDate; // data de expiração

    private LocalDateTime createdAt; // data de criação

    private LocalDateTime updatedAt; // última atualização

    public HoldResponseDTO() {
    }

    public HoldResponseDTO(
            String holdId,
            String accountId,
            BigDecimal amount,
            HoldReason reason,
            HoldStatus status,
            LocalDateTime expirationDate,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.holdId = holdId;
        this.accountId = accountId;
        this.amount = amount;
        this.reason = reason;
        this.status = status;
        this.expirationDate = expirationDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
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
}
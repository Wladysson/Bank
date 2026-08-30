package com.bank.account.hold.interfaces.rest.request;

import com.bank.account.hold.domain.model.HoldReason;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HoldRequest {

    @NotBlank
    private String accountId; // conta onde o saldo será reservado

    @NotNull
    @DecimalMin(value = "0.01")
    private BigDecimal amount; // valor da reserva

    @NotNull
    private HoldReason reason; // motivo da reserva

    @Future
    private LocalDateTime expirationDate; // data de expiração da reserva

    @NotBlank
    private String operationId; // operação que originou a reserva

    public HoldRequest() {
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
package com.bank.transactions.application.dto.request.pix;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class GeneratePixQrCodeRequest {

    @NotBlank(message = "Account id is required")
    private String accountId;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
    private BigDecimal amount;

    @Size(max = 255, message = "Description must have at most 255 characters")
    private String description;

    @Size(max = 120, message = "Payer name must have at most 120 characters")
    private String payerName;

    private boolean expirationEnabled;

    private Integer expirationInSeconds;

    public GeneratePixQrCodeRequest() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public boolean isExpirationEnabled() {
        return expirationEnabled;
    }

    public void setExpirationEnabled(boolean expirationEnabled) {
        this.expirationEnabled = expirationEnabled;
    }

    public Integer getExpirationInSeconds() {
        return expirationInSeconds;
    }

    public void setExpirationInSeconds(Integer expirationInSeconds) {
        this.expirationInSeconds = expirationInSeconds;
    }
}
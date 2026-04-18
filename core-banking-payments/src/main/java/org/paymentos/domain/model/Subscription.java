package com.bank.payments.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Subscription {

    private String id;
    private String userId;
    private String merchantId;
    private BigDecimal amount;
    private String currency;
    private String frequency;
    private LocalDate nextExecutionDate;
    private boolean active;
    private int failureCount;

    public void updateNextExecutionDate() {
        this.nextExecutionDate = this.nextExecutionDate.plusDays(30); // simplificado
    }

    public void incrementFailureCount() {
        this.failureCount++;
        if (failureCount >= 3) {
            this.active = false;
        }
    }

    // getters e setters

    public String getId() { return id; }
    public String getUserId() { return userId; }
    public String getMerchantId() { return merchantId; }
    public BigDecimal getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getFrequency() { return frequency; }
    public LocalDate getNextExecutionDate() { return nextExecutionDate; }
    public boolean isActive() { return active; }

    public void setId(String id) { this.id = id; }
    public void setUserId(String userId) { this.userId = userId; }
    public void setMerchantId(String merchantId) { this.merchantId = merchantId; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }
    public void setNextExecutionDate(LocalDate nextExecutionDate) { this.nextExecutionDate = nextExecutionDate; }
    public void setActive(boolean active) { this.active = active; }
}
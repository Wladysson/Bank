package com.bank.payments.application.dto.request;

import java.math.BigDecimal;

public class SubscriptionRequest {

    private String userId;
    private String merchantId;
    private BigDecimal amount;
    private String currency;
    private String frequency; // DAILY, WEEKLY, MONTHLY
    private int frequencyInDays;

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getMerchantId() { return merchantId; }
    public void setMerchantId(String merchantId) { this.merchantId = merchantId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }

    public int getFrequencyInDays() { return frequencyInDays; }
    public void setFrequencyInDays(int frequencyInDays) { this.frequencyInDays = frequencyInDays; }
}
package com.bank.payments.application.dto.response;

import com.bank.payments.domain.model.Subscription;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SubscriptionResponse {

    private String id;
    private String userId;
    private String merchantId;
    private BigDecimal amount;
    private String currency;
    private String frequency;
    private LocalDate nextExecutionDate;
    private boolean active;

    public SubscriptionResponse() {}

    public SubscriptionResponse(String id, String userId, String merchantId,
                                BigDecimal amount, String currency,
                                String frequency, LocalDate nextExecutionDate,
                                boolean active) {
        this.id = id;
        this.userId = userId;
        this.merchantId = merchantId;
        this.amount = amount;
        this.currency = currency;
        this.frequency = frequency;
        this.nextExecutionDate = nextExecutionDate;
        this.active = active;
    }

    public static SubscriptionResponse from(Subscription subscription) {
        return new SubscriptionResponse(
                subscription.getId(),
                subscription.getUserId(),
                subscription.getMerchantId(),
                subscription.getAmount(),
                subscription.getCurrency(),
                subscription.getFrequency(),
                subscription.getNextExecutionDate(),
                subscription.isActive()
        );
    }

    public String getId() { return id; }
    public String getUserId() { return userId; }
    public String getMerchantId() { return merchantId; }
    public BigDecimal getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getFrequency() { return frequency; }
    public LocalDate getNextExecutionDate() { return nextExecutionDate; }
    public boolean isActive() { return active; }
}
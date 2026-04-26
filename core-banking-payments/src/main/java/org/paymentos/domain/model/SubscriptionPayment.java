package com.bank.payments.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SubscriptionPayment {

    private String id;
    private String subscriptionId;
    private BigDecimal amount;
    private LocalDateTime paidAt;
    private String status;

    public SubscriptionPayment(String id, String subscriptionId, BigDecimal amount,
                               LocalDateTime paidAt, String status) {
        this.id = id;
        this.subscriptionId = subscriptionId;
        this.amount = amount;
        this.paidAt = paidAt;
        this.status = status;
    }

    public String getId() { return id; }
    public String getSubscriptionId() { return subscriptionId; }
    public BigDecimal getAmount() { return amount; }
    public LocalDateTime getPaidAt() { return paidAt; }
    public String getStatus() { return status; }
}
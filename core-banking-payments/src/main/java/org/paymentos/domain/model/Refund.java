package com.bank.payments.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Refund {

    private String id;
    private String paymentId;
    private BigDecimal amount;
    private String reason;
    private LocalDateTime createdAt;

    public Refund(String id, String paymentId, BigDecimal amount, String reason) {
        this.id = id;
        this.paymentId = paymentId;
        this.amount = amount;
        this.reason = reason;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() { return id; }
    public String getPaymentId() { return paymentId; }
    public BigDecimal getAmount() { return amount; }
    public String getReason() { return reason; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
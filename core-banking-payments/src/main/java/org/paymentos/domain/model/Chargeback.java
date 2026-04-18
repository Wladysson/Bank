package com.bank.payments.domain.model;

import java.time.LocalDateTime;

public class Chargeback {

    private String id;
    private String paymentId;
    private String reason;
    private LocalDateTime createdAt;

    public Chargeback(String id, String paymentId, String reason) {
        this.id = id;
        this.paymentId = paymentId;
        this.reason = reason;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() { return id; }
    public String getPaymentId() { return paymentId; }
    public String getReason() { return reason; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
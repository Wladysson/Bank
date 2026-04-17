package com.bank.payments.application.dto.request;

import java.math.BigDecimal;

public class RefundRequest {

    private String paymentId;
    private BigDecimal amount;
    private String reason;

    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}
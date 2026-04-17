package com.bank.payments.application.dto.response;

import com.bank.payments.domain.model.Payment;
import com.bank.payments.domain.model.PaymentStatus;

import java.math.BigDecimal;

public class PaymentResponse {

    private String paymentId;
    private PaymentStatus status;
    private BigDecimal amount;
    private String currency;
    private String description;

    public PaymentResponse() {}

    public PaymentResponse(String paymentId, PaymentStatus status,
                           BigDecimal amount, String currency, String description) {
        this.paymentId = paymentId;
        this.status = status;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
    }

    public static PaymentResponse from(Payment payment) {
        return new PaymentResponse(
                payment.getId(),
                payment.getStatus(),
                payment.getAmount(),
                payment.getCurrency(),
                payment.getDescription()
        );
    }

    public String getPaymentId() { return paymentId; }
    public PaymentStatus getStatus() { return status; }
    public BigDecimal getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getDescription() { return description; }
}
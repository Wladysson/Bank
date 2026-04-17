package com.bank.payments.application.dto.response;

import com.bank.payments.domain.model.PaymentStatus;

public class PaymentStatusResponse {

    private String paymentId;
    private PaymentStatus status;

    public PaymentStatusResponse() {}

    public PaymentStatusResponse(String paymentId, PaymentStatus status) {
        this.paymentId = paymentId;
        this.status = status;
    }

    public String getPaymentId() { return paymentId; }
    public PaymentStatus getStatus() { return status; }
}
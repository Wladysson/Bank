package com.bank.payments.application.dto.request;

import java.util.List;

public class BatchPaymentRequest {

    private List<PaymentRequest> payments;

    public List<PaymentRequest> getPayments() { return payments; }
    public void setPayments(List<PaymentRequest> payments) { this.payments = payments; }
}
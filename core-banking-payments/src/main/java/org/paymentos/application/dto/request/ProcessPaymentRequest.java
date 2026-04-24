package com.bank.payments.application.dto.request;

import java.math.BigDecimal;

public class ProcessPaymentRequest {

    private String payerId;
    private String payeeId;
    private BigDecimal amount;
    private String currency;
    private String description;

    public ProcessPaymentRequest() {
    }

    public ProcessPaymentRequest(String payerId, String payeeId,
                                 BigDecimal amount, String currency,
                                 String description) {
        this.payerId = payerId;
        this.payeeId = payeeId;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
    }

    public String getPayerId() {
        return payerId;
    }

    public String getPayeeId() {
        return payeeId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDescription() {
        return description;
    }
}
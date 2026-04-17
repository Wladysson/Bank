package com.bank.payments.application.usecase.payment;

import com.bank.payments.domain.model.PaymentMethod;
import com.bank.payments.domain.model.PaymentType;

import java.math.BigDecimal;

public class ProcessPaymentCommand {

    private String payerId;
    private String payeeId;
    private BigDecimal amount;
    private String currency;
    private PaymentMethod method;
    private PaymentType type;
    private String description;
    private String externalReference;

    public ProcessPaymentCommand() {}

    public ProcessPaymentCommand(String payerId, String payeeId, BigDecimal amount,
                                 String currency, PaymentMethod method,
                                 PaymentType type, String description,
                                 String externalReference) {
        this.payerId = payerId;
        this.payeeId = payeeId;
        this.amount = amount;
        this.currency = currency;
        this.method = method;
        this.type = type;
        this.description = description;
        this.externalReference = externalReference;
    }

    // getters e setters

    public String getPayerId() { return payerId; }
    public String getPayeeId() { return payeeId; }
    public BigDecimal getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public PaymentMethod getMethod() { return method; }
    public PaymentType getType() { return type; }
    public String getDescription() { return description; }
    public String getExternalReference() { return externalReference; }

    public void setPayerId(String payerId) { this.payerId = payerId; }
    public void setPayeeId(String payeeId) { this.payeeId = payeeId; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setMethod(PaymentMethod method) { this.method = method; }
    public void setType(PaymentType type) { this.type = type; }
    public void setDescription(String description) { this.description = description; }
    public void setExternalReference(String externalReference) { this.externalReference = externalReference; }
}
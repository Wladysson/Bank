package com.bank.payments.application.dto.request;

public class BoletoPaymentRequest {

    private String payerId;
    private String linhaDigitavel;

    public String getPayerId() { return payerId; }
    public void setPayerId(String payerId) { this.payerId = payerId; }

    public String getLinhaDigitavel() { return linhaDigitavel; }
    public void setLinhaDigitavel(String linhaDigitavel) { this.linhaDigitavel = linhaDigitavel; }
}
package com.bank.payments.application.dto.request;

public class QRCodePaymentRequest {

    private String payerId;
    private String qrCode;

    public String getPayerId() { return payerId; }
    public void setPayerId(String payerId) { this.payerId = payerId; }

    public String getQrCode() { return qrCode; }
    public void setQrCode(String qrCode) { this.qrCode = qrCode; }
}
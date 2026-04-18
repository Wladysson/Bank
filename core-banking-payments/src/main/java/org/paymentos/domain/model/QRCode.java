package com.bank.payments.domain.model;

public class QRCode {

    private String code;
    private String merchant;
    private String payload;

    public QRCode(String code, String merchant, String payload) {
        this.code = code;
        this.merchant = merchant;
        this.payload = payload;
    }

    public String getCode() { return code; }
    public String getMerchant() { return merchant; }
    public String getPayload() { return payload; }
}
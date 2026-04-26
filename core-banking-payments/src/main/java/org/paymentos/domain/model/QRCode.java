package com.bank.payments.domain.model;

public class QRCode {

    private String id;
    private String status;
    private String code;
    private String merchant;
    private String payload;

    public QRCode(String id, String status, String code, String merchant, String payload) {
        this.id = id;
        this.status = status;
        this.code = code;
        this.merchant = merchant;
        this.payload = payload;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMerchant() {
        return merchant;
    }

    public String getPayload() {
        return payload;
    }
}
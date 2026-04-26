package com.bank.payments.application.dto.response;

public class QRCodeStatusResponse {

    private String id;
    private String status;

    public QRCodeStatusResponse(String id, String status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}
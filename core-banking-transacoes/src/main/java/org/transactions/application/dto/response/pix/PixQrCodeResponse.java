package com.bank.transactions.application.dto.response.pix;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PixQrCodeResponse {

    private String qrCodeId;
    private String qrCode;
    private String copyAndPasteCode;
    private String qrCodeType;
    private BigDecimal amount;
    private String payerName;
    private String status;
    private LocalDateTime expirationDate;
    private LocalDateTime createdAt;

    public PixQrCodeResponse() {
    }

    public String getQrCodeId() {
        return qrCodeId;
    }

    public void setQrCodeId(String qrCodeId) {
        this.qrCodeId = qrCodeId;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getCopyAndPasteCode() {
        return copyAndPasteCode;
    }

    public void setCopyAndPasteCode(String copyAndPasteCode) {
        this.copyAndPasteCode = copyAndPasteCode;
    }

    public String getQrCodeType() {
        return qrCodeType;
    }

    public void setQrCodeType(String qrCodeType) {
        this.qrCodeType = qrCodeType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
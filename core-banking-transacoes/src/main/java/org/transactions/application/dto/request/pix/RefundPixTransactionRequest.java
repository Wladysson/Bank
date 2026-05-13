package com.bank.transactions.application.dto.request.pix;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RefundPixTransactionRequest {

    @NotBlank(message = "Transaction id is required")
    private String transactionId;

    @NotBlank(message = "Requester account id is required")
    private String requesterAccountId;

    @Size(max = 255, message = "Refund reason must have at most 255 characters")
    private String reason;

    @NotBlank(message = "Transaction password is required")
    private String transactionPassword;

    public RefundPixTransactionRequest() {
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getRequesterAccountId() {
        return requesterAccountId;
    }

    public void setRequesterAccountId(String requesterAccountId) {
        this.requesterAccountId = requesterAccountId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTransactionPassword() {
        return transactionPassword;
    }

    public void setTransactionPassword(String transactionPassword) {
        this.transactionPassword = transactionPassword;
    }
}
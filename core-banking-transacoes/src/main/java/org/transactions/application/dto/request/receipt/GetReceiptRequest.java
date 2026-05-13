package com.bank.transactions.application.dto.request.receipt;

import jakarta.validation.constraints.NotBlank;

public class GetReceiptRequest {

    @NotBlank(message = "Transaction id is required")
    private String transactionId;

    @NotBlank(message = "Requester account id is required")
    private String requesterAccountId;

    public GetReceiptRequest() {
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
}
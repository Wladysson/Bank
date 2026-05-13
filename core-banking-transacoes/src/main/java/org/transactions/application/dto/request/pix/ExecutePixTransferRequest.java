package com.bank.transactions.application.dto.request.pix;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class ExecutePixTransferRequest {

    @NotBlank(message = "Sender account id is required")
    private String senderAccountId;

    @NotBlank(message = "Receiver pix key is required")
    @Size(max = 255, message = "Pix key must have at most 255 characters")
    private String receiverPixKey;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
    private BigDecimal amount;

    @Size(max = 255, message = "Description must have at most 255 characters")
    private String description;

    @NotBlank(message = "Transaction password is required")
    private String transactionPassword;

    public ExecutePixTransferRequest() {
    }

    public String getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(String senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public String getReceiverPixKey() {
        return receiverPixKey;
    }

    public void setReceiverPixKey(String receiverPixKey) {
        this.receiverPixKey = receiverPixKey;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransactionPassword() {
        return transactionPassword;
    }

    public void setTransactionPassword(String transactionPassword) {
        this.transactionPassword = transactionPassword;
    }
}
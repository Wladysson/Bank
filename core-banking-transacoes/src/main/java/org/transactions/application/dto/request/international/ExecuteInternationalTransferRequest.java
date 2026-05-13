package com.bank.transactions.application.dto.request.international;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class ExecuteInternationalTransferRequest {

    @NotBlank(message = "Sender account id is required")
    private String senderAccountId;

    @NotBlank(message = "Receiver full name is required")
    @Size(max = 150, message = "Receiver full name must have at most 150 characters")
    private String receiverFullName;

    @NotBlank(message = "Receiver country is required")
    private String receiverCountry;

    @NotBlank(message = "Receiver bank name is required")
    private String receiverBankName;

    @NotBlank(message = "SWIFT code is required")
    @Pattern(
            regexp = "^[A-Z0-9]{8}(?:[A-Z0-9]{3})?$",
            message = "Invalid SWIFT code format"
    )
    private String swiftCode;

    @NotBlank(message = "IBAN is required")
    private String iban;

    @NotBlank(message = "Target currency is required")
    @Pattern(
            regexp = "^[A-Z]{3}$",
            message = "Currency must follow ISO-4217 format"
    )
    private String targetCurrency;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
    private BigDecimal amount;

    @NotBlank(message = "Remittance purpose is required")
    private String remittancePurpose;

    @Size(max = 255, message = "Description must have at most 255 characters")
    private String description;

    @NotBlank(message = "Transaction password is required")
    private String transactionPassword;

    public ExecuteInternationalTransferRequest() {
    }

    public String getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(String senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public String getReceiverFullName() {
        return receiverFullName;
    }

    public void setReceiverFullName(String receiverFullName) {
        this.receiverFullName = receiverFullName;
    }

    public String getReceiverCountry() {
        return receiverCountry;
    }

    public void setReceiverCountry(String receiverCountry) {
        this.receiverCountry = receiverCountry;
    }

    public String getReceiverBankName() {
        return receiverBankName;
    }

    public void setReceiverBankName(String receiverBankName) {
        this.receiverBankName = receiverBankName;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRemittancePurpose() {
        return remittancePurpose;
    }

    public void setRemittancePurpose(String remittancePurpose) {
        this.remittancePurpose = remittancePurpose;
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
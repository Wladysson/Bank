package com.bank.transactions.application.dto.request.recurring;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateRecurringPaymentRequest {

    @NotBlank(message = "Source account id is required")
    private String sourceAccountId;

    @NotBlank(message = "Destination identifier is required")
    private String destinationIdentifier;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
    private BigDecimal amount;

    @NotBlank(message = "Recurrence frequency is required")
    private String recurrenceFrequency;

    @NotNull(message = "Start date is required")
    @Future(message = "Start date must be in the future")
    private LocalDate startDate;

    private LocalDate endDate;

    @Size(max = 255, message = "Description must have at most 255 characters")
    private String description;

    @NotBlank(message = "Transaction password is required")
    private String transactionPassword;

    public CreateRecurringPaymentRequest() {
    }

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(String sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public String getDestinationIdentifier() {
        return destinationIdentifier;
    }

    public void setDestinationIdentifier(String destinationIdentifier) {
        this.destinationIdentifier = destinationIdentifier;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRecurrenceFrequency() {
        return recurrenceFrequency;
    }

    public void setRecurrenceFrequency(String recurrenceFrequency) {
        this.recurrenceFrequency = recurrenceFrequency;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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
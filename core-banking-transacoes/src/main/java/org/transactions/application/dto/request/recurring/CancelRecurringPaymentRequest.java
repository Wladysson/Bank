package com.bank.transactions.application.dto.request.recurring;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CancelRecurringPaymentRequest {

    @NotBlank(message = "Recurring payment id is required")
    private String recurringPaymentId;

    @Size(max = 255, message = "Cancellation reason must have at most 255 characters")
    private String cancellationReason;

    @NotBlank(message = "Requested by is required")
    private String requestedBy;

    @NotBlank(message = "Transaction password is required")
    private String transactionPassword;

    public CancelRecurringPaymentRequest() {
    }

    public String getRecurringPaymentId() {
        return recurringPaymentId;
    }

    public void setRecurringPaymentId(String recurringPaymentId) {
        this.recurringPaymentId = recurringPaymentId;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getTransactionPassword() {
        return transactionPassword;
    }

    public void setTransactionPassword(String transactionPassword) {
        this.transactionPassword = transactionPassword;
    }
}
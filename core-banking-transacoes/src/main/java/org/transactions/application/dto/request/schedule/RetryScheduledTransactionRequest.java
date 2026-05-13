package com.bank.transactions.application.dto.request.schedule;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RetryScheduledTransactionRequest {

    @NotBlank(message = "Scheduled transaction id is required")
    private String scheduledTransactionId;

    @NotNull(message = "Retry attempt is required")
    private Integer retryAttempt;

    @NotBlank(message = "Requested by is required")
    private String requestedBy;

    private boolean forceRetry;

    public RetryScheduledTransactionRequest() {
    }

    public String getScheduledTransactionId() {
        return scheduledTransactionId;
    }

    public void setScheduledTransactionId(String scheduledTransactionId) {
        this.scheduledTransactionId = scheduledTransactionId;
    }

    public Integer getRetryAttempt() {
        return retryAttempt;
    }

    public void setRetryAttempt(Integer retryAttempt) {
        this.retryAttempt = retryAttempt;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public boolean isForceRetry() {
        return forceRetry;
    }

    public void setForceRetry(boolean forceRetry) {
        this.forceRetry = forceRetry;
    }
}
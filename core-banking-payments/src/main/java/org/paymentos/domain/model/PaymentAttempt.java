package com.bank.payments.domain.model;

import java.time.LocalDateTime;

public class PaymentAttempt {

    private int attemptNumber;
    private boolean success;
    private String errorMessage;
    private LocalDateTime timestamp;

    public PaymentAttempt(int attemptNumber, boolean success, String errorMessage) {
        this.attemptNumber = attemptNumber;
        this.success = success;
        this.errorMessage = errorMessage;
        this.timestamp = LocalDateTime.now();
    }

    public int getAttemptNumber() { return attemptNumber; }
    public boolean isSuccess() { return success; }
    public String getErrorMessage() { return errorMessage; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
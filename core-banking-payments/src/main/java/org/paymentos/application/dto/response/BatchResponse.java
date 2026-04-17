package com.bank.payments.application.dto.response;

import java.util.List;

public class BatchResponse {

    private List<PaymentResponse> successPayments;
    private List<String> failedPayments;

    public BatchResponse() {}

    public BatchResponse(List<PaymentResponse> successPayments,
                         List<String> failedPayments) {
        this.successPayments = successPayments;
        this.failedPayments = failedPayments;
    }

    public List<PaymentResponse> getSuccessPayments() {
        return successPayments;
    }

    public List<String> getFailedPayments() {
        return failedPayments;
    }
}
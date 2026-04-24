package com.bank.payments.domain.model;

import com.bank.payments.application.usecase.payment.ProcessPaymentCommand;

import java.time.LocalDateTime;

public class Payment {

    private String id;
    private String payerId;
    private String payeeId;
    private Money amount;
    private PaymentStatus status;
    private PaymentMethod method;
    private PaymentType type;
    private String description;
    private String externalReference;
    private LocalDateTime createdAt;
    private String failureReason;

    private Payment() {}

    public static Payment create(ProcessPaymentCommand command) {
        Payment payment = new Payment();
        payment.id = PaymentId.generate().getValue();
        payment.payerId = command.getPayerId();
        payment.payeeId = command.getPayeeId();
        payment.amount = new Money(command.getAmount(), command.getCurrency());
        payment.method = command.getMethod();
        payment.type = command.getType();
        payment.description = command.getDescription();
        payment.externalReference = command.getExternalReference();
        payment.status = PaymentStatus.CREATED;
        payment.createdAt = LocalDateTime.now();
        return payment;
    }

    // regras de transição

    public void markAsProcessed() {
        validateState(PaymentStatus.CREATED, PaymentStatus.PROCESSING);
        this.status = PaymentStatus.PROCESSING;
    }

    public void markAsProcessing() {
        this.status = PaymentStatus.PROCESSING; //chama la do batchprocessingjob
    }

    public void markAsAuthorized() {
        validateState(PaymentStatus.PROCESSING, PaymentStatus.AUTHORIZED);
        this.status = PaymentStatus.AUTHORIZED;
    }

    public void markAsCaptured() {
        validateState(PaymentStatus.AUTHORIZED, PaymentStatus.CAPTURED);
        this.status = PaymentStatus.CAPTURED;
    }

    public void markAsFailed() {
        this.status = PaymentStatus.FAILED;
    }

    public void markAsRefunded() {
        validateState(PaymentStatus.CAPTURED, PaymentStatus.REFUNDED);
        this.status = PaymentStatus.REFUNDED;
    }

    public void markAsFailed(String reason) {
        this.status = PaymentStatus.FAILED;
        this.failureReason = reason;
    }

    public void markAsChargeback() {
        this.status = PaymentStatus.CHARGEBACK;
    }

    private void validateState(PaymentStatus expected, PaymentStatus next) {
        if (this.status != expected) {
            throw new IllegalStateException(
                    "Transição inválida de " + this.status + " para " + next
            );
        }
    }

    // getters

    public String getId() { return id; }
    public String getPayerId() { return payerId; }
    public String getPayeeId() { return payeeId; }
    public PaymentStatus getStatus() { return status; }
    public String getDescription() { return description; }
    public String getCurrency() { return amount.getCurrency(); }
    public java.math.BigDecimal getAmount() { return amount.getAmount(); }
    public String getFailureReason() { return failureReason; }
}
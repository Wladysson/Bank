package com.bank.payments.domain.exception;

public class InsufficientFundsException extends PaymentDomainException {

    public InsufficientFundsException(String message) {
        super(message);
    }
}
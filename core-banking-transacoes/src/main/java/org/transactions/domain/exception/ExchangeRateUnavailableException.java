package com.bank.transactions.domain.exception;

// Exceção responsável pela indisponibilidade cambial
public class ExchangeRateUnavailableException extends TransactionException {

    public ExchangeRateUnavailableException() {
        super("Taxa de câmbio indisponível no momento");
    }

    public ExchangeRateUnavailableException(String message) {
        super(message);
    }
}
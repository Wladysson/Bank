package com.bank.transactions.domain.exception;

// Exceção responsável por saldo insuficiente
public class InsufficientBalanceException extends TransactionException {

    public InsufficientBalanceException() {
        super("Saldo insuficiente para realizar a operação");
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
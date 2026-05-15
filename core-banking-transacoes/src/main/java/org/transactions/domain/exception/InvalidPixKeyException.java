package com.bank.transactions.domain.exception;

// Exceção responsável por chave PIX inválida
public class InvalidPixKeyException extends TransactionException {

    public InvalidPixKeyException() {
        super("Chave PIX inválida");
    }

    public InvalidPixKeyException(String message) {
        super(message);
    }
}
package com.bank.transactions.domain.exception;

// Exceção responsável pela indisponibilidade da janela bancária
public class BankTransferWindowClosedException extends TransactionException {

    public BankTransferWindowClosedException() {
        super("Janela operacional bancária encerrada");
    }

    public BankTransferWindowClosedException(String message) {
        super(message);
    }
}
package com.bank.account.domain.exception;

import java.util.UUID;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(UUID accountId) {
        super("Conta não encontrada para o ID: " + accountId);
    }

    public AccountNotFoundException(String accountNumber) {
        super("Conta não encontrada para o número: " + accountNumber);
    }
}
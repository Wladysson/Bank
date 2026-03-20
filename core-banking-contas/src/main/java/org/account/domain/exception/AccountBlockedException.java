package com.bank.account.domain.exception;

import java.util.UUID;

public class AccountBlockedException extends RuntimeException {

    public AccountBlockedException(UUID accountId) {
        super("A conta está bloqueada: " + accountId);
    }

    public AccountBlockedException(UUID accountId, String reason) {
        super("A conta está bloqueada: " + accountId + ". Motivo: " + reason);
    }
}
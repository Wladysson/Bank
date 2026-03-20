package com.bank.account.domain.exception;

import java.math.BigDecimal;
import java.util.UUID;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(UUID accountId, BigDecimal attemptedAmount) {
        super("Saldo insuficiente na conta " + accountId +
                " para o valor: " + attemptedAmount);
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
package com.bank.account.domain.exception;

import com.bank.account.domain.model.AccountStatus;

public class InvalidAccountStatusTransitionException extends RuntimeException {

    private final AccountStatus from;
    private final AccountStatus to;

    public InvalidAccountStatusTransitionException(AccountStatus from, AccountStatus to) {
        super("Invalid account status transition from " + from + " to " + to); // mensagem padrão de domínio
        this.from = from; // status origem da transição
        this.to = to; // status destino da transição
    }

    public AccountStatus getFrom() {
        return from; // retorna status anterior
    }

    public AccountStatus getTo() {
        return to; // retorna status solicitado
    }
}
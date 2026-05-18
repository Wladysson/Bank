package com.bank.transactions.domain.exception;

import com.bank.transactions.domain.exception.TransactionException;

// Exceção responsável por falhas em agendamentos
public class ScheduleExecutionException extends TransactionException {

    public ScheduleExecutionException() {
        super("Falha ao executar transação agendada");
    }

    public ScheduleExecutionException(String message) {
        super(message);
    }
}
package com.seubanco.transactions.domain.exception;

// Exceção responsável por falhas em agendamentos
public class ScheduleExecutionException extends TransactionException {

    public ScheduleExecutionException() {
        super("Falha ao executar transação agendada");
    }

    public ScheduleExecutionException(String message) {
        super(message);
    }
}
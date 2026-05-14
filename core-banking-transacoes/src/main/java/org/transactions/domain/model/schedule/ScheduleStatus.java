package com.bank.transactions.domain.model.schedule;

// Enum responsável pelos status do agendamento
public enum ScheduleStatus {

    PENDING,
    PROCESSING,
    COMPLETED,
    FAILED,
    CANCELLED,
    RETRYING
}
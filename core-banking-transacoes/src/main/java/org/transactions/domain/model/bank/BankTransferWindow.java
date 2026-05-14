package com.bank.transactions.domain.model.bank;

import java.time.LocalTime;

// Value Object responsável pela janela operacional bancária
public class BankTransferWindow {

    // Horário inicial permitido
    private final LocalTime startTime;

    // Horário final permitido
    private final LocalTime endTime;

    public BankTransferWindow(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Verifica se horário informado está dentro da janela
    public boolean isWithinWindow(LocalTime currentTime) {
        return !currentTime.isBefore(startTime)
                && !currentTime.isAfter(endTime);
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
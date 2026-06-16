package com.bank.account.balance.infrastructure.observability;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

public class BalanceMetrics {

    private final AtomicLong creditOperations = new AtomicLong(); // quantidade de créditos executados

    private final AtomicLong debitOperations = new AtomicLong(); // quantidade de débitos executados

    private final AtomicLong reservationOperations = new AtomicLong(); // quantidade de reservas realizadas

    private final AtomicLong insufficientBalanceEvents = new AtomicLong(); // falhas por saldo insuficiente

    private BigDecimal totalCreditedAmount = BigDecimal.ZERO; // volume total creditado

    private BigDecimal totalDebitedAmount = BigDecimal.ZERO; // volume total debitado

    public void registerCredit(
            BigDecimal amount
    ) {

        creditOperations.incrementAndGet(); // incrementa contador de créditos

        totalCreditedAmount =
                totalCreditedAmount.add(amount); // acumula volume financeiro creditado
    }

    public void registerDebit(
            BigDecimal amount
    ) {

        debitOperations.incrementAndGet(); // incrementa contador de débitos

        totalDebitedAmount =
                totalDebitedAmount.add(amount); // acumula volume financeiro debitado
    }

    public void registerReservation() {

        reservationOperations.incrementAndGet(); // incrementa contador de reservas
    }

    public void registerInsufficientBalance() {

        insufficientBalanceEvents.incrementAndGet(); // registra tentativa sem saldo disponível
    }

    public long getCreditOperations() {
        return creditOperations.get();
    }

    public long getDebitOperations() {
        return debitOperations.get();
    }

    public long getReservationOperations() {
        return reservationOperations.get();
    }

    public long getInsufficientBalanceEvents() {
        return insufficientBalanceEvents.get();
    }

    public BigDecimal getTotalCreditedAmount() {
        return totalCreditedAmount;
    }

    public BigDecimal getTotalDebitedAmount() {
        return totalDebitedAmount;
    }
}
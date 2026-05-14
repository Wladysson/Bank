package com.bank.transactions.domain.model.recurring;

import com.bank.transactions.domain.model.common.Money;

import java.time.LocalDate;

// Entidade responsável pelos pagamentos recorrentes
public class RecurringPayment {

    // Identificador único da recorrência
    private String recurringPaymentId;

    // Conta de origem da cobrança
    private String sourceAccountId;

    // Identificador do destinatário
    private String destinationIdentifier;

    // Valor recorrente
    private Money amount;

    // Frequência da recorrência
    private RecurrenceFrequency frequency;

    // Status atual da recorrência
    private RecurringPaymentStatus status;

    // Data inicial da recorrência
    private LocalDate startDate;

    // Próxima execução programada
    private LocalDate nextExecutionDate;

    // Data final da recorrência
    private LocalDate endDate;

    // Pausa recorrência temporariamente
    public void pause() {
        this.status = RecurringPaymentStatus.PAUSED;
    }

    // Cancela recorrência permanentemente
    public void cancel() {
        this.status = RecurringPaymentStatus.CANCELLED;
    }

    // Marca recorrência como ativa
    public void activate() {
        this.status = RecurringPaymentStatus.ACTIVE;
    }

    public String getRecurringPaymentId() {
        return recurringPaymentId;
    }

    public void setRecurringPaymentId(String recurringPaymentId) {
        this.recurringPaymentId = recurringPaymentId;
    }

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(String sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public String getDestinationIdentifier() {
        return destinationIdentifier;
    }

    public void setDestinationIdentifier(String destinationIdentifier) {
        this.destinationIdentifier = destinationIdentifier;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public RecurrenceFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(RecurrenceFrequency frequency) {
        this.frequency = frequency;
    }

    public RecurringPaymentStatus getStatus() {
        return status;
    }

    public void setStatus(RecurringPaymentStatus status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getNextExecutionDate() {
        return nextExecutionDate;
    }

    public void setNextExecutionDate(LocalDate nextExecutionDate) {
        this.nextExecutionDate = nextExecutionDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
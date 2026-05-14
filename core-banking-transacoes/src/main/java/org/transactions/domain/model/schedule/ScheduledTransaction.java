package com.bank.transactions.domain.model.schedule;

import com.bank.transactions.domain.model.common.Money;
import com.bank.transactions.domain.model.common.Transaction;

import java.time.LocalDateTime;

// Entidade responsável por transações agendadas
public class ScheduledTransaction extends Transaction {

    // Identificador da conta de origem
    private String sourceAccountId;

    // Identificador do destino da transação
    private String destinationIdentifier;

    // Valor agendado
    private Money amount;

    // Data programada para execução
    private LocalDateTime scheduledAt;

    // Status atual do agendamento
    private ScheduleStatus status;

    // Política de retentativa
    private RetryPolicy retryPolicy;

    // Quantidade de tentativas realizadas
    private Integer retryCount = 0;

    // Marca execução como concluída
    public void markAsCompleted() {
        this.status = ScheduleStatus.COMPLETED;
    }

    // Incrementa contador de retentativas
    public void incrementRetry() {
        this.retryCount++;
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

    public LocalDateTime getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(LocalDateTime scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public ScheduleStatus getStatus() {
        return status;
    }

    public void setStatus(ScheduleStatus status) {
        this.status = status;
    }

    public RetryPolicy getRetryPolicy() {
        return retryPolicy;
    }

    public void setRetryPolicy(RetryPolicy retryPolicy) {
        this.retryPolicy = retryPolicy;
    }

    public Integer getRetryCount() {
        return retryCount;
    }
}
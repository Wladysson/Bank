package com.bank.transactions.infrastructure.config;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

// Configurações relacionadas aos schedulers
@ApplicationScoped
public class SchedulerConfig {

    // Intervalo de processamento de agendamentos
    @ConfigProperty(name = "scheduler.scheduled-transaction.interval")
    String scheduledTransactionInterval;

    // Intervalo de processamento recorrente
    @ConfigProperty(name = "scheduler.recurring-payment.interval")
    String recurringPaymentInterval;

    public String getScheduledTransactionInterval() {
        return scheduledTransactionInterval;
    }

    public String getRecurringPaymentInterval() {
        return recurringPaymentInterval;
    }
}
package com.bank.account.infrastructure.observability;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;

public class AccountMetrics {

    private final Counter accountCreatedCounter;
    private final Counter accountClosedCounter;
    private final Counter accountBlockedCounter;
    private final Timer accountSearchTimer;

    public AccountMetrics(MeterRegistry registry) {

        this.accountCreatedCounter =
                Counter.builder("account.created.total")
                        .description("Total number of created accounts")
                        .register(registry); // registra métrica de abertura

        this.accountClosedCounter =
                Counter.builder("account.closed.total")
                        .description("Total number of closed accounts")
                        .register(registry); // registra métrica de encerramento

        this.accountBlockedCounter =
                Counter.builder("account.blocked.total")
                        .description("Total number of blocked accounts")
                        .register(registry); // registra métrica de bloqueio

        this.accountSearchTimer =
                Timer.builder("account.search.duration")
                        .description("Account search execution time")
                        .register(registry); // registra tempo das consultas
    }

    public void incrementCreatedAccounts() {
        accountCreatedCounter.increment(); // incrementa abertura de conta
    }

    public void incrementClosedAccounts() {
        accountClosedCounter.increment(); // incrementa encerramento
    }

    public void incrementBlockedAccounts() {
        accountBlockedCounter.increment(); // incrementa bloqueio
    }

    public Timer accountSearchTimer() {
        return accountSearchTimer; // expõe timer para medições
    }
}
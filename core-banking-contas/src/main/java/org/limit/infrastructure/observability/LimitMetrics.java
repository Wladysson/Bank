package com.bank.account.limit.infrastructure.observability;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class LimitMetrics {

    private final AtomicLong configuredLimits = new AtomicLong(); // quantidade de limites configurados
    private final AtomicLong consumedLimits = new AtomicLong(); // quantidade de consumos registrados
    private final AtomicLong rejectedOperations = new AtomicLong(); // operações rejeitadas por limite
    private final AtomicLong changedLimits = new AtomicLong(); // alterações realizadas nos limites
    private final AtomicReference<BigDecimal> totalConsumedAmount =
            new AtomicReference<>(BigDecimal.ZERO); // valor total consumido

    public void registerConfigured() {

        configuredLimits.incrementAndGet(); // registra nova configuração
    }

    public void registerConsumed(
            BigDecimal amount
    ) {

        if (amount == null || amount.signum() <= 0) {
            return; // ignora consumo inválido
        }

        consumedLimits.incrementAndGet(); // registra consumo

        totalConsumedAmount.updateAndGet(
                current -> current.add(amount)
        ); // acumula valor consumido
    }

    public void registerRejected() {

        rejectedOperations.incrementAndGet(); // registra operação recusada
    }

    public void registerChanged() {

        changedLimits.incrementAndGet(); // registra alteração de limite
    }

    public long getConfiguredLimits() {
        return configuredLimits.get();
    }

    public long getConsumedLimits() {
        return consumedLimits.get();
    }

    public long getRejectedOperations() {
        return rejectedOperations.get();
    }

    public long getChangedLimits() {
        return changedLimits.get();
    }

    public BigDecimal getTotalConsumedAmount() {
        return totalConsumedAmount.get();
    }
}
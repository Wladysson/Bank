package com.bank.transactions.domain.model.schedule;

// Value Object responsável pelas regras de retentativa
public class RetryPolicy {

    // Quantidade máxima de tentativas
    private final Integer maxRetries;

    // Intervalo entre tentativas em minutos
    private final Integer retryIntervalMinutes;

    public RetryPolicy(
            Integer maxRetries,
            Integer retryIntervalMinutes
    ) {
        this.maxRetries = maxRetries;
        this.retryIntervalMinutes = retryIntervalMinutes;
    }

    // Verifica se ainda é possível tentar novamente
    public boolean canRetry(Integer currentRetryCount) {
        return currentRetryCount < maxRetries;
    }

    public Integer getMaxRetries() {
        return maxRetries;
    }

    public Integer getRetryIntervalMinutes() {
        return retryIntervalMinutes;
    }
}
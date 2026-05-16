package com.bank.transactions.infrastructure.config;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

// Configurações gerais do módulo transacional
@ApplicationScoped
public class TransactionConfig {

    // Limite máximo permitido por transação
    @ConfigProperty(name = "transaction.limit.max")
    String maxTransactionLimit;

    // Quantidade máxima de tentativas
    @ConfigProperty(name = "transaction.retry.max-attempts")
    Integer maxRetryAttempts;

    // Tempo limite de processamento
    @ConfigProperty(name = "transaction.timeout-seconds")
    Integer timeoutSeconds;

    public String getMaxTransactionLimit() {
        return maxTransactionLimit;
    }

    public Integer getMaxRetryAttempts() {
        return maxRetryAttempts;
    }

    public Integer getTimeoutSeconds() {
        return timeoutSeconds;
    }
}
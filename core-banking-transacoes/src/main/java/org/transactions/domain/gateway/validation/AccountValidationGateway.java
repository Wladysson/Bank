package com.bank.transactions.domain.gateway.validation;

import com.bank.transactions.domain.model.validation.BalanceValidationResult;

// Gateway responsável pelas validações de conta
public interface AccountValidationGateway {

    // Valida saldo disponível da conta
    BalanceValidationResult validateBalance(
            String accountId,
            java.math.BigDecimal amount
    );

    // Verifica se conta está ativa
    boolean isAccountActive(String accountId);

    // Verifica bloqueios operacionais
    boolean hasRestrictions(String accountId);
}
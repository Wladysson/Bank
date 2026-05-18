package com.bank.transactions.infrastructure.integration.accounts;

import com.bank.transactions.domain.gateway.validation.AccountValidationGateway;
import com.bank.transactions.domain.model.validation.BalanceValidationResult;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.math.BigDecimal;
import java.util.Map;

// Implementação do gateway de validação de contas
@ApplicationScoped
public class AccountValidationGatewayImpl
        implements AccountValidationGateway {

    @RestClient
    AccountsApiClient accountsApiClient;

    // Valida saldo disponível da conta
    @Override
    public BalanceValidationResult validateBalance(
            String accountId,
            BigDecimal amount
    ) {

        Map<String, Object> response =
                accountsApiClient.validateBalance(
                        accountId,
                        amount
                );

        Boolean valid =
                (Boolean) response.get("valid");

        String reason =
                (String) response.get("reason");

        return new BalanceValidationResult(
                valid,
                new BigDecimal(response.get("availableBalance").toString()),
                amount
        );
    }

    // Verifica se conta está ativa
    @Override
    public boolean isAccountActive(String accountId) {

        Map<String, Object> response =
                accountsApiClient.getAccountStatus(accountId);

        return "ACTIVE".equals(response.get("status"));
    }

    // Verifica restrições operacionais
    @Override
    public boolean hasRestrictions(String accountId) {

        Map<String, Object> response =
                accountsApiClient.getAccountStatus(accountId);

        return Boolean.TRUE.equals(
                response.get("hasRestrictions")
        );
    }
}
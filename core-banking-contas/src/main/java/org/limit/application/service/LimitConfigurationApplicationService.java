package com.bank.account.limit.application.service;

import com.bank.account.limit.application.command.ConfigureLimitCommand;
import com.bank.account.limit.domain.model.AccountLimit;
import com.bank.account.limit.domain.repository.AccountLimitRepository;
import com.bank.account.limit.domain.service.LimitPolicyService;

import java.math.BigDecimal;

public class LimitConfigurationApplicationService {

    private final AccountLimitRepository accountLimitRepository; // repositório responsável pela persistência dos limites

    private final LimitPolicyService limitPolicyService; // serviço responsável pelas regras de política de limites

    public LimitConfigurationApplicationService(
            AccountLimitRepository accountLimitRepository,
            LimitPolicyService limitPolicyService
    ) {
        this.accountLimitRepository = accountLimitRepository;
        this.limitPolicyService = limitPolicyService;
    }

    public AccountLimit configure(
            ConfigureLimitCommand command
    ) {

        validateCommand(command); // valida os dados mínimos necessários para configuração

        BigDecimal policyLimit = limitPolicyService.calculateLimit(
                command.getLimitType(),
                command.getChannel(),
                command.getRiskProfile()
        ); // calcula o limite permitido pela política de risco

        BigDecimal configuredAmount = command.getAmount(); // obtém o valor solicitado para configuração

        if (configuredAmount.compareTo(policyLimit) > 0) {
            throw new IllegalArgumentException(
                    "Configured limit exceeds the policy limit"
            ); // impede configuração acima do limite permitido
        }

        AccountLimit accountLimit = new AccountLimit(
                command.getAccountId(),
                command.getLimitType(),
                command.getChannel(),
                command.getLimitInterval(),
                configuredAmount,
                command.getRiskProfile()
        ); // cria a configuração de limite no domínio

        return accountLimitRepository.save(accountLimit); // persiste o limite configurado
    }

    private void validateCommand(
            ConfigureLimitCommand command
    ) {

        if (command == null) {
            throw new IllegalArgumentException(
                    "Configure limit command cannot be null"
            ); // impede processamento de comando inexistente
        }

        if (command.getAccountId() == null
                || command.getAccountId().isBlank()) {
            throw new IllegalArgumentException(
                    "Account id cannot be null or blank"
            ); // garante identificação da conta
        }

        if (command.getAmount() == null
                || command.getAmount().signum() <= 0) {
            throw new IllegalArgumentException(
                    "Limit amount must be greater than zero"
            ); // garante valor de limite positivo
        }

        if (command.getLimitType() == null) {
            throw new IllegalArgumentException(
                    "Limit type cannot be null"
            ); // garante classificação do limite
        }

        if (command.getChannel() == null) {
            throw new IllegalArgumentException(
                    "Account channel cannot be null"
            ); // garante canal da operação
        }

        if (command.getLimitInterval() == null) {
            throw new IllegalArgumentException(
                    "Limit interval cannot be null"
            ); // garante período de avaliação
        }

        if (command.getRiskProfile() == null) {
            throw new IllegalArgumentException(
                    "Risk profile cannot be null"
            ); // garante classificação de risco
        }
    }
}
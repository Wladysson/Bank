package com.bank.account.application.service;

import com.bank.account.application.command.ActivateAccountCommand;
import com.bank.account.application.command.BlockAccountCommand;
import com.bank.account.application.command.ChangeAccountStatusCommand;
import com.bank.account.application.command.SuspendAccountCommand;
import com.bank.account.application.command.UnblockAccountCommand;
import com.bank.account.domain.model.Account;
import com.bank.account.domain.model.AccountStatus;
import com.bank.account.domain.model.AccountStatusReason;
import com.bank.account.domain.service.AccountStatusTransitionPolicy;

import jakarta.enterprise.context.ApplicationScoped;

/**
 * Serviço responsável por operações administrativas
 * relacionadas ao status de contas bancárias.
 */
@ApplicationScoped
public class AccountStatusApplicationService {

    private final AccountStatusTransitionPolicy transitionPolicy;

    public AccountStatusApplicationService(
            AccountStatusTransitionPolicy transitionPolicy
    ) {
        this.transitionPolicy = transitionPolicy;
    }

    /**
     * Ativa uma conta previamente criada.
     */
    public void activate(
            ActivateAccountCommand command
    ) {

        // TODO:
        // localizar conta
        // validar regras
        // alterar status para ACTIVE
        // persistir alterações
    }

    /**
     * Bloqueia uma conta.
     */
    public void block(
            BlockAccountCommand command
    ) {

        // TODO:
        // localizar conta
        // alterar status para BLOCKED
        // registrar motivo
        // persistir alterações
    }

    /**
     * Remove bloqueio da conta.
     */
    public void unblock(
            UnblockAccountCommand command
    ) {

        // TODO:
        // localizar conta
        // alterar status para ACTIVE
        // persistir alterações
    }

    /**
     * Suspende uma conta.
     */
    public void suspend(
            SuspendAccountCommand command
    ) {

        // TODO:
        // localizar conta
        // alterar status para SUSPENDED
        // persistir alterações
    }

    /**
     * Altera status de forma genérica.
     */
    public void changeStatus(
            ChangeAccountStatusCommand command
    ) {

        // TODO:
        // buscar conta
        // converter command -> status
        // validar transição
        // persistir alterações
    }

    /**
     * Método de domínio reutilizável.
     */
    public void changeStatus(
            Account account,
            AccountStatus newStatus,
            AccountStatusReason reason
    ) {

        transitionPolicy.validate(
                account.getStatus(),
                newStatus,
                reason
        );

        account.changeStatus(
                newStatus,
                reason
        );
    }

    /**
     * Consulta status atual da conta.
     */
    public AccountStatus getStatus(
            Account account
    ) {
        return account.getStatus();
    }
}
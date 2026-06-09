package com.bank.account.application.command;

import com.bank.account.account.domain.model.AccountId;
 //Command responsável por ativar uma conta
 //Parte do fluxo CQRS (write side)
public class ActivateAccountCommand {

    private final AccountId accountId;

    public ActivateAccountCommand(AccountId accountId) {
        this.accountId = accountId; // identifica a conta que será ativada
    }

    public AccountId getAccountId() {
        return accountId; // retorna conta alvo da ativação
    }
}
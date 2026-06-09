package com.bank.account.application.command;

import com.bank.account.account.domain.model.AccountId;

public class UnblockAccountCommand {

    private final AccountId accountId;

    public UnblockAccountCommand(AccountId accountId) {
        this.accountId = accountId; // conta que será desbloqueada
    }

    public AccountId getAccountId() {
        return accountId; // retorna identificador da conta
    }
}
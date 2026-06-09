package com.bank.account.application.command;

import com.bank.account.domain.model.AccountId;

public class RefreshAccountSnapshotCommand {

    private final AccountId accountId;

    public RefreshAccountSnapshotCommand(AccountId accountId) {
        this.accountId = accountId; // conta que terá snapshot atualizado
    }

    public AccountId getAccountId() {
        return accountId; // retorna identificador da conta
    }
}
package com.bank.account.application.query;

import com.bank.account.domain.model.AccountId;

public class GetAccountByIdQuery {

    private final AccountId accountId;

    public GetAccountByIdQuery(AccountId accountId) {
        this.accountId = accountId; // identificador da conta consultada
    }

    public AccountId getAccountId() {
        return accountId; // retorna o identificador da conta
    }
}
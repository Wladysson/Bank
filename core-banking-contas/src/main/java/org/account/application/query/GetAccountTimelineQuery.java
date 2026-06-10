package com.bank.account.account.application.query;

import com.bank.account.account.domain.model.AccountId;

public class GetAccountTimelineQuery {

    private final AccountId accountId;

    public GetAccountTimelineQuery(AccountId accountId) {
        this.accountId = accountId; // conta que terá histórico consultado
    }

    public AccountId getAccountId() {
        return accountId; // retorna conta consultada
    }
}
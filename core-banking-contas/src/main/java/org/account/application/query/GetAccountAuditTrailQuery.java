package com.bank.account.account.application.query;

import com.bank.account.account.domain.model.AccountId;

public class GetAccountAuditTrailQuery {

    private final AccountId accountId;

    public GetAccountAuditTrailQuery(AccountId accountId) {
        this.accountId = accountId; // conta que terá auditoria consultada
    }

    public AccountId getAccountId() {
        return accountId; // retorna identificador da conta auditada
    }
}
package com.bank.account.limit.application.query;

public class GetLimitsByAccountQuery {

    private final String accountId; // identificador da conta utilizada na consulta

    public GetLimitsByAccountQuery(
            String accountId
    ) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }
}
package com.bank.account.balance.application.query;

public class GetAvailableBalanceQuery {

    private final String accountId; // conta consultada

    public GetAvailableBalanceQuery(
            String accountId
    ) {

        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }
}
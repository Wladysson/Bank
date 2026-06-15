package com.bank.account.hold.application.query;

public class GetHoldsByAccountQuery {

    private final String accountId; // conta consultada

    public GetHoldsByAccountQuery(
            String accountId
    ) {

        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }
}
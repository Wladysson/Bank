package com.bank.account.application.query;

import com.bank.account.domain.model.AccountNumber;

public class GetAccountByNumberQuery {

    private final AccountNumber accountNumber;

    public GetAccountByNumberQuery(AccountNumber accountNumber) {
        this.accountNumber = accountNumber; // número da conta consultada
    }

    public AccountNumber getAccountNumber() {
        return accountNumber; // retorna número da conta
    }
}
package com.bank.account.account.application.query;

import com.bank.account.domain.model.AccountStatus;
import com.bank.account.domain.model.AccountType;
import com.bank.account.account.domain.model.CustomerId;

public class SearchAccountsQuery {

    private final CustomerId customerId;
    private final AccountStatus status;
    private final AccountType accountType;

    public SearchAccountsQuery(
            CustomerId customerId,
            AccountStatus status,
            AccountType accountType
    ) {
        this.customerId = customerId; // filtro por cliente
        this.status = status; // filtro por status
        this.accountType = accountType; // filtro por tipo de conta
    }

    public CustomerId getCustomerId() {
        return customerId; // retorna filtro de cliente
    }

    public AccountStatus getStatus() {
        return status; // retorna filtro de status
    }

    public AccountType getAccountType() {
        return accountType; // retorna filtro de tipo
    }
}
package com.bank.account.account.domain.event;

import com.bank.account.account.domain.model.AccountId;
import com.bank.account.account.domain.model.CustomerId;

public final class AccountHolderAddedEvent {

    private final AccountId accountId;
    private final CustomerId customerId;

    public AccountHolderAddedEvent(AccountId accountId, CustomerId customerId) {
        this.accountId = accountId; // conta onde o titular foi adicionado
        this.customerId = customerId; // titular adicionado à conta
    }

    public AccountId getAccountId() {
        return accountId; // identifica a conta afetada
    }

    public CustomerId getCustomerId() {
        return customerId; // identifica o novo titular
    }
}
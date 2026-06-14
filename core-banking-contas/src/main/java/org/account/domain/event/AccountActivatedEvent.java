package com.bank.account.domain.event;

import com.bank.account.domain.model.AccountId;

public final class AccountActivatedEvent {

    private final AccountId accountId;

    public AccountActivatedEvent(AccountId accountId) {
        this.accountId = accountId; // identifica a conta ativada
    }

    public AccountId getAccountId() {
        return accountId; // retorna a conta afetada pelo evento
    }
}
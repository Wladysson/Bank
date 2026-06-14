package com.bank.account.domain.event;

import com.bank.account.domain.model.AccountId;

public final class AccountUnblockedEvent {

    private final AccountId accountId;

    public AccountUnblockedEvent(AccountId accountId) {
        this.accountId = accountId; // identifica a conta que foi desbloqueada
    }

    public AccountId getAccountId() {
        return accountId; // retorna a conta afetada pelo evento
    }
}
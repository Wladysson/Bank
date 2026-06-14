package com.bank.account.account.domain.event;

import com.bank.account.account.domain.model.AccountId;

/**
 * Evento de domínio disparado quando uma conta é suspensa
 */
public final class AccountSuspendedEvent {

    private final AccountId accountId;

    public AccountSuspendedEvent(AccountId accountId) {
        this.accountId = accountId; // conta suspensa no sistema
    }

    public AccountId getAccountId() {
        return accountId; // acesso ao identificador da conta
    }
}
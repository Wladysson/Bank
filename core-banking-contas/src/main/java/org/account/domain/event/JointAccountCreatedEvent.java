package com.bank.account.domain.event;

import com.bank.account.domain.model.AccountId;

import java.util.Set;

public final class JointAccountCreatedEvent {

    private final AccountId accountId;
    private final Set<?> holders;

    public JointAccountCreatedEvent(AccountId accountId, Set<?> holders) {
        this.accountId = accountId; // conta conjunta criada
        this.holders = Set.copyOf(holders); // titulares da conta conjunta
    }

    public AccountId getAccountId() {
        return accountId; // retorna conta criada
    }

    public Set<?> getHolders() {
        return holders; // retorna titulares da conta conjunta
    }
}
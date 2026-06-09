package com.bank.account.application.command;

import com.bank.account.account.domain.model.AccountId;
import com.bank.account.account.domain.model.AccountStatusReason;

public class SuspendAccountCommand {

    private final AccountId accountId;
    private final AccountStatusReason reason;

    public SuspendAccountCommand(AccountId accountId, AccountStatusReason reason) {
        this.accountId = accountId; // conta que será suspensa
        this.reason = reason; // motivo da suspensão
    }

    public AccountId getAccountId() {
        return accountId; // retorna conta alvo
    }

    public AccountStatusReason getReason() {
        return reason; // retorna motivo da suspensão
    }
}
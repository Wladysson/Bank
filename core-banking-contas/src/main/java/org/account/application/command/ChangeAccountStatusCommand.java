package com.bank.account.application.command;

import com.bank.account.account.domain.model.AccountId;
import com.bank.account.domain.model.AccountStatus;
import com.bank.account.account.domain.model.AccountStatusReason;

public class ChangeAccountStatusCommand {

    private final AccountId accountId;
    private final AccountStatus targetStatus;
    private final AccountStatusReason reason;

    public ChangeAccountStatusCommand(
            AccountId accountId,
            AccountStatus targetStatus,
            AccountStatusReason reason
    ) {
        this.accountId = accountId; // conta que terá o status alterado
        this.targetStatus = targetStatus; // novo status desejado
        this.reason = reason; // motivo da alteração
    }

    public AccountId getAccountId() {
        return accountId; // retorna identificador da conta
    }

    public AccountStatus getTargetStatus() {
        return targetStatus; // retorna status solicitado
    }

    public AccountStatusReason getReason() {
        return reason; // retorna justificativa da alteração
    }
}
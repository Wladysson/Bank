package com.bank.account.application.command;

import com.bank.account.domain.model.AccountId;
import com.bank.account.domain.model.CustomerId;

public class RemoveJointHolderCommand {

    private final AccountId accountId;
    private final CustomerId customerId;

    public RemoveJointHolderCommand(
            AccountId accountId,
            CustomerId customerId
    ) {
        this.accountId = accountId; // conta que sofrerá alteração de titularidade
        this.customerId = customerId; // titular que será removido
    }

    public AccountId getAccountId() {
        return accountId; // retorna identificador da conta
    }

    public CustomerId getCustomerId() {
        return customerId; // retorna titular a ser removido
    }
}
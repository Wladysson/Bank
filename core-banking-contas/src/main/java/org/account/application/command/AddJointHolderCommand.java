package com.bank.account.account.application.command;

import com.bank.account.account.domain.model.AccountId;
import com.bank.account.account.domain.model.CustomerId;

public class AddJointHolderCommand {

    private final AccountId accountId;
    private final CustomerId customerId;

    public AddJointHolderCommand(
            AccountId accountId,
            CustomerId customerId
    ) {
        this.accountId = accountId; // conta que receberá o novo titular
        this.customerId = customerId; // cliente que será adicionado
    }

    public AccountId getAccountId() {
        return accountId; // retorna identificador da conta
    }

    public CustomerId getCustomerId() {
        return customerId; // retorna titular a ser adicionado
    }
}
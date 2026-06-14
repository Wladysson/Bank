package com.bank.account.account.domain.specification;

import com.bank.account.domain.model.Account;
import com.bank.account.domain.model.AccountStatus;

public final class AccountCanBeBlockedSpecification {

     //Regra de validação para bloqueio de conta
    public boolean isSatisfiedBy(Account account) {
        if (account == null) { // valida entrada
            return false;
        }

        AccountStatus status = account.getStatus(); // status atual da conta

        return status == AccountStatus.ACTIVE; // apenas contas ativas podem ser bloqueadas
    }
}
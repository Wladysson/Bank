package com.bank.account.account.domain.specification;

import com.bank.account.domain.model.Account;
import com.bank.account.domain.model.AccountStatus;

public final class AccountCanBeClosedSpecification {

    //Regra principal de validação para encerramento de conta
    public boolean isSatisfiedBy(Account account) {
        if (account == null) { // valida entrada
            return false;
        }

        AccountStatus status = account.getStatus(); // obtém status atual

        return status != AccountStatus.CLOSED; // conta já fechada não pode ser fechada novamente
    }
}
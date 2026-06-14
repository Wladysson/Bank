package com.bank.account.application.service;

import com.bank.account.domain.model.Account;
import com.bank.account.domain.model.AccountStatus;
import com.bank.account.domain.model.AccountStatusReason;
import com.bank.account.domain.service.AccountStatusTransitionPolicy;

 //Serviço de aplicação responsável por operações de status da conta
 //Orquestra regras de domínio e policies sem conter lógica de negócio
public class AccountStatusApplicationService {

    private final AccountStatusTransitionPolicy transitionPolicy;

    public AccountStatusApplicationService(AccountStatusTransitionPolicy transitionPolicy) {
        this.transitionPolicy = transitionPolicy; // injeta policy de transição de status
    }

    public void changeStatus(Account account, AccountStatus newStatus, AccountStatusReason reason) {
        transitionPolicy.validate(account.getStatus(), newStatus, reason); // valida regra de transição

        account.changeStatus(newStatus, reason); // delega mudança para o agregado
    }

    public AccountStatus getStatus(Account account) {
        return account.getStatus(); // retorna status atual da conta
    }
}
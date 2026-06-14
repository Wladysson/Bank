package com.bank.account.account.domain.service;

import com.bank.account.domain.model.AccountStatus;
import com.bank.account.account.domain.model.AccountStatusReason;

import java.util.EnumSet;

//Policy que define as regras de transição de status da conta
//Centraliza o controle de estados permitidos no ciclo de vida da conta

public final class AccountStatusTransitionPolicy {

     //Mapa conceitual de transições permitidas entre status
     //Regra de domínio: nem toda mudança de status é válida

    public boolean canTransition(AccountStatus from, AccountStatus to) {
        if (from == null || to == null) { // valida entrada da transição
            return false;
        }

        // regras básicas de transição de estado
        return switch (from) {
            case ACTIVE -> EnumSet.of(AccountStatus.BLOCKED, AccountStatus.SUSPENDED, AccountStatus.CLOSED).contains(to);
            case BLOCKED -> EnumSet.of(AccountStatus.ACTIVE, AccountStatus.SUSPENDED, AccountStatus.CLOSED).contains(to);
            case SUSPENDED -> EnumSet.of(AccountStatus.ACTIVE, AccountStatus.CLOSED).contains(to);
            case CLOSED -> false; // conta encerrada não pode mudar de estado
        };
    }

     //Valida transição e lança exceção se inválida
    public void validate(AccountStatus from, AccountStatus to, AccountStatusReason reason) {
        if (!canTransition(from, to)) { // valida regra de negócio de transição
            throw new IllegalStateException(
                    "Invalid transition from " + from + " to " + to + " reason=" + reason
            );
        }
    }
}
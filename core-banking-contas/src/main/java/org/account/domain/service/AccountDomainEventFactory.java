package com.bank.account.account.domain.service;

import com.bank.account.account.domain.event.AccountCreatedEvent;
import com.bank.account.account.domain.event.AccountClosedEvent;
import com.bank.account.account.domain.event.AccountBlockedEvent;
import com.bank.account.account.domain.model.AccountId;
import com.bank.account.account.domain.model.AccountStatus;

 //Factory responsável por criar eventos de domínio relacionados ao ciclo de vida da conta
 //Centraliza a criação de eventos para garantir consistência e padronização

public final class AccountDomainEventFactory {

    public AccountCreatedEvent createAccountCreated(AccountId accountId) {
        return new AccountCreatedEvent(accountId); // evento de criação de conta
    }

    public AccountClosedEvent createAccountClosed(AccountId accountId) {
        return new AccountClosedEvent(accountId); // evento de encerramento de conta
    }

    public AccountBlockedEvent createAccountBlocked(AccountId accountId, String reason) {
        return new AccountBlockedEvent(accountId, reason); // evento de bloqueio com motivo
    }

    public Object createStatusChanged(AccountId accountId, AccountStatus status) {
        return new AccountStatusChangedEvent(accountId, status); // evento de mudança de status
    }
}
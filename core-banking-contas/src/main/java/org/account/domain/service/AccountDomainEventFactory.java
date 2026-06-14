package com.bank.account.domain.service;

import com.bank.account.domain.event.AccountCreatedEvent;
import com.bank.account.domain.event.AccountClosedEvent;
import com.bank.account.domain.event.AccountBlockedEvent;
import com.bank.account.domain.event.AccountStatusChangedEvent;
import java.util.UUID;

//Factory responsável por criar eventos de domínio relacionados ao ciclo de vida da conta
//Centraliza a criação de eventos para garantir consistência e padronização

public final class AccountDomainEventFactory {

    public AccountCreatedEvent createAccountCreated(UUID accountId, String accountNumber, String accountType, UUID primaryHolderId) {
       return new AccountCreatedEvent(accountId, accountNumber, accountType, primaryHolderId); // evento de criação de conta
    }

    public AccountClosedEvent createAccountClosed(UUID accountId, String reason) {
       return new AccountClosedEvent(accountId, reason); // evento de encerramento de conta
    }

    public AccountBlockedEvent createAccountBlocked(UUID accountId, String reason) {
       return new AccountBlockedEvent(accountId, reason); // evento de bloqueio com motivo
    }

    public AccountStatusChangedEvent createStatusChanged(UUID accountId, String status) {
       return new AccountStatusChangedEvent(accountId, status); // evento de mudança de status
    }
}
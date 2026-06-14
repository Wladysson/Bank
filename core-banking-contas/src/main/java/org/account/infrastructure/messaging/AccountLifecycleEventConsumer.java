package com.bank.account.infrastructure.messaging;

import com.bank.account.domain.event.AccountActivatedEvent;
import com.bank.account.domain.event.AccountSuspendedEvent;
import com.bank.account.domain.event.AccountUnblockedEvent;
import com.bank.account.domain.event.AccountBlockedEvent;
import com.bank.account.domain.event.AccountClosedEvent;
import com.bank.account.domain.event.AccountCreatedEvent;
import com.bank.account.domain.event.AccountStatusChangedEvent;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

@ApplicationScoped
public class AccountLifecycleEventConsumer {

    private static final Logger LOG =
            Logger.getLogger(AccountLifecycleEventConsumer.class);

    public void onAccountCreated(AccountCreatedEvent event) {

        LOG.infof(
                "Processando AccountCreatedEvent para conta %s",
                event.getAccountId()
        ); // registra recebimento do evento
    }

    public void onAccountActivated(AccountActivatedEvent event) {

        LOG.infof(
                "Processando AccountActivatedEvent para conta %s",
                event.getAccountId()
        ); // registra ativação da conta
    }

    public void onAccountBlocked(AccountBlockedEvent event) {

        LOG.infof(
                "Processando AccountBlockedEvent para conta %s",
                event.getAccountId()
        ); // registra bloqueio da conta
    }

    public void onAccountUnblocked(AccountUnblockedEvent event) {

        LOG.infof(
                "Processando AccountUnblockedEvent para conta %s",
                event.getAccountId()
        ); // registra desbloqueio da conta
    }

    public void onAccountSuspended(AccountSuspendedEvent event) {

        LOG.infof(
                "Processando AccountSuspendedEvent para conta %s",
                event.getAccountId()
        ); // registra suspensão da conta
    }

    public void onAccountClosed(AccountClosedEvent event) {

        LOG.infof(
                "Processando AccountClosedEvent para conta %s",
                event.getAccountId()
        ); // registra encerramento da conta
    }

    public void onAccountStatusChanged(AccountStatusChangedEvent event) {

        LOG.infof(
                "Processando AccountStatusChangedEvent para conta %s",
                event.getAccountId()
        ); // registra alteração de status
    }
}
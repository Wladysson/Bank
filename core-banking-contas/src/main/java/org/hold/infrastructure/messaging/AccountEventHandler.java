package com.bank.account.hold.infrastructure.messaging;

import com.bank.account.domain.event.AccountBlockedEvent;
import com.bank.account.domain.event.AccountClosedEvent;
import com.bank.account.domain.event.AccountCreatedEvent;
import com.bank.account.domain.service.HoldManagementService;

public class AccountEventHandler {

    private final HoldManagementService holdManagementService;

    public AccountEventHandler(
            HoldManagementService holdManagementService
    ) {
        this.holdManagementService = holdManagementService;
    }

    public void onAccountCreated(
            AccountCreatedEvent event
    ) {

        // inicializa estruturas necessárias para gerenciamento de holds

        holdManagementService.initializeAccount(event.getAccountId());
    }

    public void onAccountBlocked(
            AccountBlockedEvent event
    ) {

        // impede novas reservas enquanto a conta estiver bloqueada

        holdManagementService.disableNewHolds(event.getAccountId());
    }

    public void onAccountClosed(
            AccountClosedEvent event
    ) {

        // libera ou encerra todas as reservas pendentes da conta

        holdManagementService.releaseAll(event.getAccountId());
    }
}
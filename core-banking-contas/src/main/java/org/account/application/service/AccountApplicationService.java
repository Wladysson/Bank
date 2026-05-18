package com.bank.account.application.service;

import com.bank.account.application.command.*;
import com.bank.account.domain.event.AccountCreatedEvent;
import com.bank.account.domain.model.Account;
import com.bank.account.infrastructure.messaging.KafkaAccountEventProducer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.UUID;

@ApplicationScoped
@Transactional
public class AccountApplicationService {

    @Inject
    AccountOpeningService openingService;

    @Inject
    AccountClosureService closureService;

    @Inject
    KafkaAccountEventProducer kafkaAccountEventProducer;

    public Account openAccount(OpenAccountCommand command) {

        Account account = openingService.open(command);

        AccountCreatedEvent event = new AccountCreatedEvent(
                account.getAccountId(),
                account.getAccountNumber(),
                account.getType().name(),
                command.getCustomerId()
        );

        kafkaAccountEventProducer.publish(event);

        return account;
    }

    public void closeAccount(CloseAccountCommand command) {

        // futuramente:
        // AccountClosedEvent

    }

    public void blockAccount(BlockAccountCommand command) {

        // futuramente:
        // AccountBlockedEvent

    }
}
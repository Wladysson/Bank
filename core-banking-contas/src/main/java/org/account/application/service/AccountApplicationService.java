package com.bank.account.application.service;

import com.bank.account.application.command.*;
import com.bank.account.domain.event.AccountCreatedEvent;
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

    public void openAccount(OpenAccountCommand command) {

        openingService.open(command);

        AccountCreatedEvent event = new AccountCreatedEvent(
                command.getCustomerId(),
                "00012345",
                command.getAccountType(),
                command.getCustomerId()
        );

        kafkaAccountEventProducer.publish(event);

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
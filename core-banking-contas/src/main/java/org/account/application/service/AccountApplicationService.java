package com.bank.account.application.service;

import com.bank.account.application.command.*;
import com.bank.account.infrastructure.messaging.KafkaAccountEventProducer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AccountApplicationService {

    @Inject
    AccountOpeningService openingService;

    @Inject
    AccountClosureService closureService;

    @Inject
    KafkaAccountEventProducer kafkaAccountEventProducer;

    public void openAccount(OpenAccountCommand command) {

        openingService.open(command);

        kafkaAccountEventProducer.publish("Conta criada");

    }

    public void closeAccount(CloseAccountCommand command) {

        closureService.close(command);

        kafkaAccountEventProducer.publish("Conta encerrada");

    }

    public void blockAccount(BlockAccountCommand command) {

        // delegaria para lifecycle service

        kafkaAccountEventProducer.publish("Conta bloqueada");

    }
}
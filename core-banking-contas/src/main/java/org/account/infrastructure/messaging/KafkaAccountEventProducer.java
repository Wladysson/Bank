package com.bank.account.infrastructure.messaging;

import com.bank.account.domain.event.AccountCreatedEvent;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class KafkaAccountEventProducer {

    @Inject
    @Channel("account-events-out")
    Emitter<AccountCreatedEvent> emitter;

    public void publish(AccountCreatedEvent event) {

        emitter.send(event);

    }
}
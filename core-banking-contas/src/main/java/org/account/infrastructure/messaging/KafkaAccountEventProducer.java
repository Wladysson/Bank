package com.bank.account.infrastructure.messaging;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class KafkaAccountEventProducer {

    @Inject
    @Channel("account-events-out")
    Emitter<String> emitter;

    public void publish(String event) {
        emitter.send(event);
    }
}
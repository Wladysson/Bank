package com.bank.payments.infrastructure.messaging.producer;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class DeadLetterProducer {

    @Channel("payment-dlq-out")
    Emitter<String> emitter;

    public void send(String message) {
        emitter.send(message);
    }
}
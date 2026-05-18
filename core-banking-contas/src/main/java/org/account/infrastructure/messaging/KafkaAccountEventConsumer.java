package com.bank.accounts.infrastructure.messaging;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class KafkaAccountEventConsumer {

    @Incoming("account-events")
    public void consume(String message) {

        System.out.println("Evento recebido: " + message);

    }
}
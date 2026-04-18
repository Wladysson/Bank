package com.bank.payments.infrastructure.messaging.consumer;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class ReconciliationConsumer {

    @Incoming("reconciliation-in")
    public void consume(String message) {
        System.out.println("Evento de reconciliacao: " + message);

        // comparar com ledger/gateway
    }
}
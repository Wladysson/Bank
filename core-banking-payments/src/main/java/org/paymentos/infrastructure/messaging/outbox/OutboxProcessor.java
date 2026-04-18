package com.bank.payments.infrastructure.messaging.outbox;

import com.bank.payments.infrastructure.messaging.producer.PaymentEventProducer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class OutboxProcessor {

    @Inject
    OutboxRepository repository;

    @Inject
    PaymentEventProducer producer;

    @Transactional
    public void process() {

        List<OutboxEntity> events = repository.findUnprocessed();

        for (OutboxEntity event : events) {
            try {
                producer.send(event.getPayload());
                repository.markAsProcessed(event.getId());
            } catch (Exception e) {
                // aqui pode mandar pra DLQ depois
                System.err.println("Erro ao processar outbox: " + e.getMessage());
            }
        }
    }
}
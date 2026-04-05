package com.bank.ledger.infrastructure.messaging;

import com.bank.ledger.domain.event.DomainEventPublisher;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaDomainEventPublisher implements DomainEventPublisher {

    @Override
    public void publish(Object event) {
        // TODO: enviar para Kafka
        System.out.println("Evento publicado: " + event);
    }
}
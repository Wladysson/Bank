package com.bank.payments.infrastructure.messaging.outbox;

import com.bank.payments.domain.event.PaymentEvent;
import com.bank.payments.infrastructure.messaging.producer.PaymentEventProducer;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    private final ObjectMapper mapper = new ObjectMapper();

    @Transactional
    public void process() {

        List<OutboxEntity> events = repository.findUnprocessed();

        for (OutboxEntity event : events) {
            try {

                PaymentEvent paymentEvent =
                        mapper.readValue(event.getPayload(), PaymentEvent.class);

                producer.send(paymentEvent);

                repository.markAsProcessed(event.getId());

            } catch (Exception e) {
                System.err.println("Erro ao processar outbox id="
                        + event.getId() + ": " + e.getMessage());
            }
        }
    }
}
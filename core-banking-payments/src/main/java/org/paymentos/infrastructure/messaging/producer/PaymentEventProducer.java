package com.bank.payments.infrastructure.messaging.producer;

import com.bank.payments.domain.event.PaymentEvent;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class PaymentEventProducer {

    @Channel("payment-events-out")
    Emitter<PaymentEvent> emitter;

    public void send(PaymentEvent event) {
        emitter.send(event);
    }
}
package com.bank.payments.infrastructure.messaging;

import com.bank.payments.application.messaging.PaymentEventPublisher;
import com.bank.payments.domain.event.PaymentEvent;

import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.logging.Log;

@ApplicationScoped
public class PaymentEventPublisherImpl implements PaymentEventPublisher {

    @Override
    public void publish(PaymentEvent event) {
        // agora simples (stub funcional)
        Log.infof("Publicando evento: %s para paymentId=%s",
                event.getClass().getSimpleName(),
                event.getPaymentId());
    }
}
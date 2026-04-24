package com.bank.payments.application.messaging;

import com.bank.payments.domain.event.PaymentEvent;

public interface PaymentEventPublisher {
    void publish(PaymentEvent event);
}
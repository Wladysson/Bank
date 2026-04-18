package com.bank.payments.infrastructure.messaging.consumer;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class PaymentCallbackConsumer {

    @Incoming("payment-callbacks-in")
    public void consume(String message) {
        System.out.println("Callback recebido: " + message);

        // aqui você vai:
        // - atualizar pagamento
        // - mudar status
        // - disparar evento
    }
}
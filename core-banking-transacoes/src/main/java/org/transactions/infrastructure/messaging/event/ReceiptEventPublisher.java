package com.bank.transactions.infrastructure.messaging.event;

import com.bank.transactions.domain.event.common.ReceiptGeneratedEvent;
import jakarta.enterprise.context.ApplicationScoped;

// Publisher responsável pelos eventos de comprovantes
@ApplicationScoped
public class ReceiptEventPublisher {

    // Publica evento de geração de comprovante
    public void publishReceiptGenerated(
            ReceiptGeneratedEvent event
    ) {

        System.out.println(
                "Comprovante gerado para transação: "
                        + event.getTransactionId()
        );
    }
}
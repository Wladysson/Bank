package com.bank.transactions.infrastructure.messaging.event;

import com.bank.transactions.domain.event.common.TransactionCompletedEvent;
import com.bank.transactions.domain.event.common.TransactionCreatedEvent;
import jakarta.enterprise.context.ApplicationScoped;

// Publisher responsável pelos eventos transacionais
@ApplicationScoped
public class TransactionEventPublisher {

    // Publica evento de criação de transação
    public void publishCreatedEvent(
            TransactionCreatedEvent event
    ) {

        System.out.println(
                "Evento de transação criada publicado: "
                        + event.getTransactionId()
        );
    }

    // Publica evento de conclusão de transação
    public void publishCompletedEvent(
            TransactionCompletedEvent event
    ) {

        System.out.println(
                "Evento de transação concluída publicado: "
                        + event.getTransactionId()
        );
    }
}
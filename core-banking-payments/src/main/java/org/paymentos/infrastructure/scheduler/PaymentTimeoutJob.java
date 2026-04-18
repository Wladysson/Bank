package com.bank.payments.infrastructure.scheduler;

import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class PaymentTimeoutJob {

    @Scheduled(every = "1m")
    void checkTimeouts() {

        System.out.println("Verificando pagamentos expirados...");

        // futuro:
        // - buscar pagamentos PROCESSING antigos
        // - marcar como FAILED
        // - disparar evento
    }
}
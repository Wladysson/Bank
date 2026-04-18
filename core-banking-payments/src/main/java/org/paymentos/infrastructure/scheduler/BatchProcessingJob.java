package com.bank.payments.infrastructure.scheduler;

import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class BatchProcessingJob {

    @Scheduled(every = "30s")
    void processBatch() {

        System.out.println("Executando processamento de lote...");

        // futuro:
        // - buscar batches pendentes
        // - processar pagamentos
        // - atualizar status
    }
}
package com.bank.payments.infrastructure.scheduler;

import com.bank.payments.domain.model.Payment;
import com.bank.payments.domain.model.PaymentStatus;
import com.bank.payments.domain.repository.PaymentRepository;
import com.bank.payments.application.messaging.PaymentEventPublisher;
import com.bank.payments.domain.event.PaymentRequestedEvent;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class BatchProcessingJob {

    private static final int BATCH_SIZE = 100;

    @Inject
    PaymentRepository paymentRepository;

    @Inject
    PaymentEventPublisher paymentEventPublisher;

    @Scheduled(every = "30s")
    @Transactional
    void processBatch() {

        Log.info("Iniciando processamento de lote de pagamentos pendentes...");

        List<Payment> pendingPayments =
                paymentRepository.findByStatus(PaymentStatus.PENDING, BATCH_SIZE);

        if (pendingPayments.isEmpty()) {
            Log.debug("Nenhum pagamento pendente encontrado para processamento.");
            return;
        }

        Log.infof("%d pagamento(s) encontrado(s) para processamento.", pendingPayments.size());

        for (Payment payment : pendingPayments) {
            try {
                Log.infof("Processando pagamento %s", payment.getId());

                payment.markAsProcessing();
                paymentRepository.update(payment);

                paymentEventPublisher.publish(
                        new PaymentRequestedEvent(payment)
                );

                Log.infof("Pagamento %s enviado para processamento assíncrono.", payment.getId());

            } catch (Exception e) {
                Log.errorf(e, "Erro ao processar pagamento %s", payment.getId());

                payment.markAsFailed();
                paymentRepository.update(payment);
            }
        }

        Log.info("Processamento de lote finalizado.");
    }
}

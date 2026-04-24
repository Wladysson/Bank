package com.bank.payments.infrastructure.scheduler;

import com.bank.payments.domain.model.Payment;
import com.bank.payments.domain.model.PaymentStatus;
import com.bank.payments.domain.repository.PaymentRepository;
import com.bank.payments.application.messaging.PaymentEventPublisher;
import com.bank.payments.domain.event.PaymentTimeoutEvent;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class PaymentTimeoutJob {

    private static final long TIMEOUT_MINUTES = 15;

    @Inject
    PaymentRepository paymentRepository;

    @Inject
    PaymentEventPublisher paymentEventPublisher;

    @Scheduled(every = "1m")
    @Transactional
    void checkTimeouts() {

        Log.info("Verificando pagamentos expirados...");

        LocalDateTime timeoutLimit = LocalDateTime.now().minusMinutes(TIMEOUT_MINUTES);

        List<Payment> timedOutPayments =
                paymentRepository.findProcessingOlderThan(timeoutLimit);

        if (timedOutPayments.isEmpty()) {
            Log.debug("Nenhum pagamento expirado encontrado.");
            return;
        }

        Log.infof("%d pagamento(s) expirado(s) encontrado(s).", timedOutPayments.size());

        for (Payment payment : timedOutPayments) {
            try {
                Log.warnf("Pagamento %s expirou durante o processamento.", payment.getId());

                payment.markAsFailed("Timeout no processamento após " + TIMEOUT_MINUTES + " minutos.");
                paymentRepository.update(payment);

                paymentEventPublisher.publish(
                        new PaymentTimeoutEvent(payment)
                );

                Log.infof("Evento de timeout publicado para pagamento %s.", payment.getId());

            } catch (Exception e) {
                Log.errorf(e, "Erro ao tratar timeout do pagamento %s", payment.getId());
            }
        }

        Log.info("Verificação de timeouts finalizada.");
    }
}

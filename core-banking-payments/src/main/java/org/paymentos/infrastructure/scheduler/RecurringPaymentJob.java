package com.bank.payments.infrastructure.scheduler;

import com.bank.payments.application.messaging.PaymentEventPublisher;
import com.bank.payments.application.usecase.payment.ProcessPaymentCommand;
import com.bank.payments.application.usecase.payment.ProcessPaymentUseCase;
import com.bank.payments.domain.model.Subscription;
import com.bank.payments.domain.repository.SubscriptionRepository;
import com.bank.payments.domain.model.PaymentMethod;
import com.bank.payments.domain.model.PaymentType;

import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class RecurringPaymentJob {

    private static final int MAX_RETRY_ATTEMPTS = 3;

    @Inject
    SubscriptionRepository subscriptionRepository;

    @Inject
    ProcessPaymentUseCase processPaymentUseCase;

    @Inject
    PaymentEventPublisher paymentEventPublisher;

    @Scheduled(every = "1h")
    @Transactional
    void processRecurringPayments() {

        Log.info("Iniciando processamento de pagamentos recorrentes...");

        List<Subscription> subscriptions =
                subscriptionRepository.findActiveDueSubscriptions(LocalDate.now());

        if (subscriptions.isEmpty()) {
            Log.debug("Nenhuma recorrência pendente para processamento.");
            return;
        }

        Log.infof("%d recorrência(s) encontrada(s) para processamento.", subscriptions.size());

        for (Subscription subscription : subscriptions) {
            try {
                Log.infof("Processando recorrência %s para cliente %s",
                        subscription.getId(),
                        subscription.getUserId());

                ProcessPaymentCommand command = buildPaymentCommand(subscription);

                processPaymentUseCase.execute(command);

                subscription.updateNextExecutionDate();
                subscription.resetFailureCount();

                subscriptionRepository.update(subscription);

                Log.infof("Recorrência %s processada com sucesso.", subscription.getId());

            } catch (Exception e) {
                handleProcessingFailure(subscription, e);
            }
        }

        Log.info("Processamento de recorrências finalizado.");
    }

    private ProcessPaymentCommand buildPaymentCommand(Subscription subscription) {
        return new ProcessPaymentCommand(
                subscription.getUserId(),                          // payerId
                subscription.getMerchantId(),                      // payeeId
                subscription.getAmount(),
                subscription.getCurrency(),

                PaymentMethod.QR_CODE,                             // método (ajuste se for PIX depois)
                PaymentType.RECURRING,                             // tipo

                "Pagamento recorrente - assinatura " + subscription.getId(),
                subscription.getId() + "-" + System.currentTimeMillis()
        );
    }

    private void handleProcessingFailure(Subscription subscription, Exception e) {

        Log.errorf(e, "Erro ao processar recorrência %s", subscription.getId());

        subscription.incrementFailureCount();

        if (subscription.getFailureCount() >= MAX_RETRY_ATTEMPTS) {
            subscription.suspend();

            Log.warnf("Recorrência %s suspensa após %d falhas.",
                    subscription.getId(),
                    MAX_RETRY_ATTEMPTS);
        }

        subscriptionRepository.update(subscription);
    }
}
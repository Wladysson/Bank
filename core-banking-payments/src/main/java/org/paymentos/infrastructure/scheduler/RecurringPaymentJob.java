package com.bank.payments.infrastructure.scheduler;

import com.bank.payments.domain.model.Subscription;
import com.bank.payments.domain.repository.SubscriptionRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import io.quarkus.scheduler.Scheduled;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class RecurringPaymentJob {

    @Inject
    SubscriptionRepository repository;

    @Scheduled(every = "1h")
    void processRecurringPayments() {

        List<Subscription> subscriptions =
                repository.findActiveDueSubscriptions(LocalDate.now());

        for (Subscription sub : subscriptions) {
            try {
                System.out.println("Processando recorrencia: " + sub.getId());

                // aqui você vai integrar com o fluxo de pagamento depois

                sub.updateNextExecutionDate();
                repository.update(sub);

            } catch (Exception e) {
                sub.incrementFailureCount();
                repository.update(sub);
            }
        }
    }
}
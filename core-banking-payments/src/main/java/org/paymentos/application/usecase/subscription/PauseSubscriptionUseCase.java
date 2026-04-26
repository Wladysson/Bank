package com.bank.payments.application.usecase.subscription;

import com.bank.payments.domain.model.Subscription;
import com.bank.payments.domain.repository.SubscriptionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PauseSubscriptionUseCase {

    @Inject
    SubscriptionRepository repository;

    public Subscription execute(String id) {
        Subscription subscription = repository.findById(id);

        if (subscription == null) {
            throw new IllegalArgumentException("Assinatura não encontrada");
        }

        subscription.pause();
        repository.update(subscription);

        return subscription;
    }
}
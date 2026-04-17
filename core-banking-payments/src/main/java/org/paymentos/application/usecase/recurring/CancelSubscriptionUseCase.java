package com.bank.payments.application.usecase.recurring;

import com.bank.payments.domain.model.Subscription;
import com.bank.payments.domain.repository.SubscriptionRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CancelSubscriptionUseCase {

    @Inject
    SubscriptionRepository subscriptionRepository;

    @Transactional
    public void execute(String subscriptionId) {

        Subscription subscription = subscriptionRepository.findById(subscriptionId);

        subscription.setActive(false);

        subscriptionRepository.save(subscription);
    }
}
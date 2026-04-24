package com.bank.payments.application.usecase.webhook;

import com.bank.payments.domain.model.WebhookSubscription;
import com.bank.payments.domain.repository.WebhookSubscriptionRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ListWebhookSubscriptionsUseCase {

    @Inject
    WebhookSubscriptionRepository repository;

    public List<WebhookSubscription> execute() {
        return repository.findAll();
    }
}
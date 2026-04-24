package com.bank.payments.application.usecase.webhook;

import com.bank.payments.domain.model.WebhookSubscription;
import com.bank.payments.domain.repository.WebhookSubscriptionRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.UUID;

@ApplicationScoped
public class CreateWebhookSubscriptionUseCase {

    @Inject
    WebhookSubscriptionRepository repository;

    public WebhookSubscription execute(String url, String eventType) {

        WebhookSubscription sub = new WebhookSubscription(
                UUID.randomUUID().toString(),
                url,
                eventType,
                true
        );

        return repository.save(sub);
    }
}
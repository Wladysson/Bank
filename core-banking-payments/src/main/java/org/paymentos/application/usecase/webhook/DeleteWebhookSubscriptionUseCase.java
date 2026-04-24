package com.bank.payments.application.usecase.webhook;

import com.bank.payments.domain.repository.WebhookSubscriptionRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DeleteWebhookSubscriptionUseCase {

    @Inject
    WebhookSubscriptionRepository repository;

    public void execute(String id) {
        repository.delete(id);
    }
}
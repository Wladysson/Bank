package com.bank.payments.domain.repository;

import com.bank.payments.domain.model.WebhookSubscription;

import java.util.List;

public interface WebhookSubscriptionRepository {

    List<WebhookSubscription> findAll();

    WebhookSubscription findById(String id);

    WebhookSubscription save(WebhookSubscription subscription);

    void delete(String id);
}
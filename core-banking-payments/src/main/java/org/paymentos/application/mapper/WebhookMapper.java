package com.bank.payments.application.mapper;

import com.bank.payments.application.dto.response.WebhookSubscriptionResponse;
import com.bank.payments.domain.model.WebhookSubscription;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WebhookMapper {

    public WebhookSubscriptionResponse toResponse(WebhookSubscription sub) {
        return WebhookSubscriptionResponse.from(sub);
    }
}
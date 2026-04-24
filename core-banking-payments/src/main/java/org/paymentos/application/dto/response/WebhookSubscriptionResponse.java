package com.bank.payments.application.dto.response;

import com.bank.payments.domain.model.WebhookSubscription;

public class WebhookSubscriptionResponse {

    private String id;
    private String url;
    private String eventType;
    private boolean active;

    public static WebhookSubscriptionResponse from(WebhookSubscription sub) {
        WebhookSubscriptionResponse r = new WebhookSubscriptionResponse();
        r.id = sub.getId();
        r.url = sub.getUrl();
        r.eventType = sub.getEventType();
        r.active = sub.isActive();
        return r;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getEventType() {
        return eventType;
    }

    public boolean isActive() {
        return active;
    }
}
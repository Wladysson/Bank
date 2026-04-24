package com.bank.payments.application.dto.request;

public class WebhookSubscriptionRequest {

    private String url;
    private String eventType;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
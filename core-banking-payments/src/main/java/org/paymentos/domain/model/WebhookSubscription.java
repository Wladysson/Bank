package com.bank.payments.domain.model;

public class WebhookSubscription {

    private String id;
    private String url;
    private String eventType;
    private boolean active;

    public WebhookSubscription() {}

    public WebhookSubscription(String id, String url, String eventType, boolean active) {
        this.id = id;
        this.url = url;
        this.eventType = eventType;
        this.active = active;
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

    public void deactivate() {
        this.active = false;
    }
}
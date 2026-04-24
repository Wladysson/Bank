package com.bank.payments.infrastructure.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "webhook_subscriptions")
public class WebhookSubscriptionEntity {

    @Id
    private String id;

    private String url;

    private String eventType;

    private boolean active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
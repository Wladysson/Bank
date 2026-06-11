package com.bank.account.account.application.dto;

import java.time.Instant;

public class AccountTimelineItemDTO {

    private String eventType;
    private String description;
    private Instant occurredAt;

    public String getEventType() {
        return eventType; // tipo do evento
    }

    public void setEventType(String eventType) {
        this.eventType = eventType; // define tipo do evento
    }

    public String getDescription() {
        return description; // descrição do evento
    }

    public void setDescription(String description) {
        this.description = description; // define descrição
    }

    public Instant getOccurredAt() {
        return occurredAt; // data do evento
    }

    public void setOccurredAt(Instant occurredAt) {
        this.occurredAt = occurredAt; // define data
    }
}
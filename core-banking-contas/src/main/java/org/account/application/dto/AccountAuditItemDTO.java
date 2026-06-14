package com.bank.account.application.dto;

import java.time.Instant;

public class AccountAuditItemDTO {

    private String action;
    private String performedBy;
    private Instant performedAt;

    public String getAction() {
        return action; // ação executada
    }

    public void setAction(String action) {
        this.action = action; // define ação
    }

    public String getPerformedBy() {
        return performedBy; // usuário ou sistema executor
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy; // define executor
    }

    public Instant getPerformedAt() {
        return performedAt; // momento da execução
    }

    public void setPerformedAt(Instant performedAt) {
        this.performedAt = performedAt; // define data da execução
    }
}
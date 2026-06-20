package com.bank.account.interfaces.rest.request;

import jakarta.validation.constraints.NotBlank;

public class BlockAccountRequest {

    @NotBlank
    private String reason; // motivo do bloqueio

    @NotBlank
    private String requestedBy; // usuário ou sistema solicitante

    private String description; // detalhes complementares

    private boolean notifyCustomer; // indica envio de notificação

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNotifyCustomer() {
        return notifyCustomer;
    }

    public void setNotifyCustomer(boolean notifyCustomer) {
        this.notifyCustomer = notifyCustomer;
    }
}
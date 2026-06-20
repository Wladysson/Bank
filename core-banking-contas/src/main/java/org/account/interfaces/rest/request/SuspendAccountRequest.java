package com.bank.account.interfaces.rest.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class SuspendAccountRequest {

    @NotBlank
    private String reason; // motivo da suspensão

    @NotBlank
    private String requestedBy; // usuário ou sistema responsável pela solicitação

    private String description; // detalhes complementares da suspensão

    private LocalDateTime suspensionUntil; // data prevista para encerramento da suspensão

    private boolean notifyCustomer; // indica se o cliente deve ser notificado

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

    public LocalDateTime getSuspensionUntil() {
        return suspensionUntil;
    }

    public void setSuspensionUntil(LocalDateTime suspensionUntil) {
        this.suspensionUntil = suspensionUntil;
    }

    public boolean isNotifyCustomer() {
        return notifyCustomer;
    }

    public void setNotifyCustomer(boolean notifyCustomer) {
        this.notifyCustomer = notifyCustomer;
    }
}
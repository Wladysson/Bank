package com.bank.account.hold.interfaces.rest.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ExtendHoldRequest {

    @NotNull
    @Future
    private LocalDateTime newExpirationDate; // nova data de expiração da reserva

    @NotBlank
    private String reason; // justificativa para a extensão

    @NotBlank
    private String requestedBy; // usuário ou sistema solicitante

    public ExtendHoldRequest() {
    }

    public LocalDateTime getNewExpirationDate() {
        return newExpirationDate;
    }

    public void setNewExpirationDate(LocalDateTime newExpirationDate) {
        this.newExpirationDate = newExpirationDate;
    }

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
}
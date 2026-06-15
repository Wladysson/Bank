package com.bank.account.hold.application.command;

import java.time.LocalDateTime;

public class ExtendHoldCommand {

    private final String holdId; // identificador da reserva

    private final LocalDateTime newExpirationDate; // nova data de expiração

    private final String reason; // justificativa da extensão

    private final String requestedBy; // usuário ou sistema solicitante

    public ExtendHoldCommand(
            String holdId,
            LocalDateTime newExpirationDate,
            String reason,
            String requestedBy
    ) {
        this.holdId = holdId;
        this.newExpirationDate = newExpirationDate;
        this.reason = reason;
        this.requestedBy = requestedBy;
    }

    public String getHoldId() {
        return holdId;
    }

    public LocalDateTime getNewExpirationDate() {
        return newExpirationDate;
    }

    public String getReason() {
        return reason;
    }

    public String getRequestedBy() {
        return requestedBy;
    }
}
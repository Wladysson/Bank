package com.bank.account.hold.application.command;

public class CancelHoldCommand {

    private final String holdId; // identificador da reserva

    private final String reason; // motivo do cancelamento

    private final String cancelledBy; // usuário ou sistema que cancelou

    public CancelHoldCommand(
            String holdId,
            String reason,
            String cancelledBy
    ) {

        this.holdId = holdId;
        this.reason = reason;
        this.cancelledBy = cancelledBy;
    }

    public String getHoldId() {
        return holdId;
    }

    public String getReason() {
        return reason;
    }

    public String getCancelledBy() {
        return cancelledBy;
    }
}
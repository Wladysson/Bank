package com.bank.account.hold.domain.exception;

public class HoldNotFoundException extends RuntimeException {

    private final String holdId; // identificador do hold não encontrado

    public HoldNotFoundException(String holdId) {
        super("Hold not found: " + holdId); // mensagem padrão de erro
        this.holdId = holdId;
    }

    public String getHoldId() {
        return holdId;
    }
}
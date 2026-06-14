package com.bank.account.domain.exception;

import com.bank.account.account.domain.model.CustomerId;

import java.util.Set;

public class JointHolderValidationException extends RuntimeException {

    private final Set<CustomerId> holders;

    public JointHolderValidationException(String message, Set<CustomerId> holders) {
        super(message); // mensagem explicando a violação
        this.holders = holders; // titulares que causaram a inconsistência
    }

    public Set<CustomerId> getHolders() {
        return holders; // retorna conjunto inválido de titulares
    }
}
package com.bank.transactions.domain.model.bank;

// Entidade responsável por transferências TED
public class TedTransfer extends BankTransfer {

    // Código de autenticação TED
    private String tedProtocol;

    public String getTedProtocol() {
        return tedProtocol;
    }

    public void setTedProtocol(String tedProtocol) {
        this.tedProtocol = tedProtocol;
    }
}
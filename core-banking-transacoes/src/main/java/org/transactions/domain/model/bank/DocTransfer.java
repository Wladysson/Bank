package com.bank.transactions.domain.model.bank;

// Entidade responsável por transferências DOC
public class DocTransfer extends BankTransfer {

    // Número de protocolo DOC
    private String docProtocol;

    public String getDocProtocol() {
        return docProtocol;
    }

    public void setDocProtocol(String docProtocol) {
        this.docProtocol = docProtocol;
    }
}
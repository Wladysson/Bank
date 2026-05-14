package com.seubanco.transactions.domain.model.internal;

import com.bank.transactions.domain.model.common.Money;
import com.bank.transactions.domain.model.common.Transaction;

// Entidade responsável por transferências internas
public class InternalTransfer extends Transaction {

    // Conta de origem
    private String sourceAccountId;

    // Conta de destino
    private String destinationAccountId;

    // Valor da transferência
    private Money amount;

    // Descrição da operação
    private String description;

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(String sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public String getDestinationAccountId() {
        return destinationAccountId;
    }

    public void setDestinationAccountId(String destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }
}
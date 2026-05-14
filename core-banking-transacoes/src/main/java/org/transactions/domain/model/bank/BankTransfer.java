package com.bank.transactions.domain.model.bank;

import com.bank.transactions.domain.model.common.Money;
import com.bank.transactions.domain.model.common.Transaction;

// Entidade base para transferências bancárias
public class BankTransfer extends Transaction {

    // Banco de destino
    private String destinationBankCode;

    // Agência de destino
    private String destinationBranch;

    // Conta de destino
    private String destinationAccount;

    // Nome do favorecido
    private String beneficiaryName;

    // Documento do favorecido
    private String beneficiaryDocument;

    // Valor da transferência
    private Money amount;

    public String getDestinationBankCode() {
        return destinationBankCode;
    }

    public void setDestinationBankCode(String destinationBankCode) {
        this.destinationBankCode = destinationBankCode;
    }

    public String getDestinationBranch() {
        return destinationBranch;
    }

    public void setDestinationBranch(String destinationBranch) {
        this.destinationBranch = destinationBranch;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getBeneficiaryDocument() {
        return beneficiaryDocument;
    }

    public void setBeneficiaryDocument(String beneficiaryDocument) {
        this.beneficiaryDocument = beneficiaryDocument;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }
}
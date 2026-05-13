package com.bank.transactions.domain.model.common;

import java.time.LocalDateTime;

// Entidade responsável pelo comprovante transacional
public class Receipt {

    // Identificador do comprovante
    private String receiptId;

    // Identificador da transação
    private String transactionId;

    // URL de armazenamento do comprovante
    private String receiptUrl;

    // Data de geração do comprovante
    private LocalDateTime generatedAt;

    public Receipt() {
        this.generatedAt = LocalDateTime.now();
    }

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getReceiptUrl() {
        return receiptUrl;
    }

    public void setReceiptUrl(String receiptUrl) {
        this.receiptUrl = receiptUrl;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }
}
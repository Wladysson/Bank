package com.bank.transactions.domain.model.common;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

// Entidade base de transação do domínio
public class Transaction {

    // Identificador único da transação
    private TransactionId transactionId;

    // Tipo da transação
    private TransactionType transactionType;

    // Status atual da transação
    private TransactionStatus status;

    // Valor monetário da operação
    private Money amount;

    // Canal utilizado na operação
    private TransactionChannel channel;

    // Código autenticador da operação
    private AuthenticationCode authenticationCode;

    // Data de criação da transação
    private LocalDateTime createdAt;

    // Data de conclusão da transação
    private LocalDateTime completedAt;

    public Transaction() {
        this.transactionId = new TransactionId(UUID.randomUUID().toString());
        this.createdAt = LocalDateTime.now();
    }

    // Marca transação como concluída
    public void complete() {
        this.status = TransactionStatus.COMPLETED;
        this.completedAt = LocalDateTime.now();
    }

    // Marca transação como falha
    public void fail() {
        this.status = TransactionStatus.FAILED;
    }

    public TransactionId getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(TransactionId transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public TransactionChannel getChannel() {
        return channel;
    }

    public void setChannel(TransactionChannel channel) {
        this.channel = channel;
    }

    public AuthenticationCode getAuthenticationCode() {
        return authenticationCode;
    }

    public void setAuthenticationCode(AuthenticationCode authenticationCode) {
        this.authenticationCode = authenticationCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }
}
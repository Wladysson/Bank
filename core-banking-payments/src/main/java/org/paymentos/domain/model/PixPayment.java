package com.bank.payments.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

public class PixPayment {

    private UUID id;
    private String endToEndId;
    private String txId;
    private String payerDocument;
    private PixKey receiverKey;
    private BigDecimal amount;
    private String description;
    private PixStatus status;
    private PixTransactionType transactionType;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private OffsetDateTime completedAt;

    public PixPayment() {
        this.id = UUID.randomUUID();
        this.status = PixStatus.PENDING;
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now();
    }

    public PixPayment(String payerDocument,
                      PixKey receiverKey,
                      BigDecimal amount,
                      String description,
                      PixTransactionType transactionType) {
        this();
        this.payerDocument = payerDocument;
        this.receiverKey = receiverKey;
        this.amount = amount;
        this.description = description;
        this.transactionType = transactionType;
    }

    public void markAsCompleted(String endToEndId) {
        this.status = PixStatus.COMPLETED;
        this.endToEndId = endToEndId;
        this.completedAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now();
    }

    public void markAsFailed() {
        this.status = PixStatus.FAILED;
        this.updatedAt = OffsetDateTime.now();
    }

    public void markAsRefunded() {
        this.status = PixStatus.REFUNDED;
        this.updatedAt = OffsetDateTime.now();
    }

    public boolean isCompleted() {
        return PixStatus.COMPLETED.equals(this.status);
    }

    public UUID getId() {
        return id;
    }

    public String getEndToEndId() {
        return endToEndId;
    }

    public void setEndToEndId(String endToEndId) {
        this.endToEndId = endToEndId;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getPayerDocument() {
        return payerDocument;
    }

    public void setPayerDocument(String payerDocument) {
        this.payerDocument = payerDocument;
    }

    public PixKey getReceiverKey() {
        return receiverKey;
    }

    public void setReceiverKey(PixKey receiverKey) {
        this.receiverKey = receiverKey;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PixStatus getStatus() {
        return status;
    }

    public void markAsProcessing() {
        if (status != PixStatus.PENDING) {
            throw new IllegalStateException("Só pagamentos pendentes podem ir para processamento");
        }
        this.status = PixStatus.PROCESSING;
    }

    public void confirm() {
        if (status != PixStatus.PROCESSING) {
            throw new IllegalStateException("Só pagamentos em processamento podem ser confirmados");
        }
        this.status = PixStatus.COMPLETED;
    }

    public void cancel() {
        if (status == PixStatus.COMPLETED) {
            throw new IllegalStateException("Pagamento já concluído não pode ser cancelado");
        }
        this.status = PixStatus.CANCELLED;
    }

    public void refund() {
        if (status != PixStatus.COMPLETED) {
            throw new IllegalStateException("Só pagamentos concluídos podem ser reembolsados");
        }
        this.status = PixStatus.REFUNDED;
    }

    public PixTransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(PixTransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public OffsetDateTime getCompletedAt() {
        return completedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PixPayment that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

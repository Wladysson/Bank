package com.bank.transactions.domain.model.pix;

import com.bank.transactions.domain.model.common.Money;
import com.bank.transactions.domain.model.common.Transaction;

import java.time.LocalDateTime;

// Entidade responsável pela transação PIX
public class PixTransaction extends Transaction {

    // Chave PIX do pagador
    private PixKey senderPixKey;

    // Chave PIX do recebedor
    private PixKey receiverPixKey;

    // Tipo da transação PIX
    private PixTransactionType transactionType;

    // Status específico do PIX
    private PixTransactionStatus pixStatus;

    // Descrição enviada na transação
    private String description;

    // Horário da liquidação
    private LocalDateTime settledAt;

    // Valor da operação
    private Money amount;

    // Marca transação como liquidada
    public void settle() {
        this.pixStatus = PixTransactionStatus.SETTLED;
        this.settledAt = LocalDateTime.now();
    }

    public PixKey getSenderPixKey() {
        return senderPixKey;
    }

    public void setSenderPixKey(PixKey senderPixKey) {
        this.senderPixKey = senderPixKey;
    }

    public PixKey getReceiverPixKey() {
        return receiverPixKey;
    }

    public void setReceiverPixKey(PixKey receiverPixKey) {
        this.receiverPixKey = receiverPixKey;
    }

    public PixTransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(PixTransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public PixTransactionStatus getPixStatus() {
        return pixStatus;
    }

    public void setPixStatus(PixTransactionStatus pixStatus) {
        this.pixStatus = pixStatus;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getSettledAt() {
        return settledAt;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }
}
package com.bank.transactions.domain.model.pix;

import com.bank.transactions.domain.model.common.Money;
import com.bank.transactions.domain.model.common.Transaction;
import com.bank.transactions.domain.model.common.TransactionType;

import java.time.LocalDateTime;

public class PixTransaction extends Transaction {

    // Chave PIX do pagador
    private PixKey senderPixKey;

    // Chave PIX do recebedor
    private PixKey receiverPixKey;

    // Status espec�fico do PIX
    private PixTransactionStatus pixStatus;

    // Descri��o enviada na transa��o
    private String description;

    // Hor�rio da liquida��o
    private LocalDateTime settledAt;

    //valor
    private Money amount;

    public void settle() {
        this.pixStatus = PixTransactionStatus.SETTLED;
        this.settledAt = LocalDateTime.now();
    }

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.PIX;
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
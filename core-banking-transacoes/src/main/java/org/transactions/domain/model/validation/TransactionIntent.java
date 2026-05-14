package com.bank.transactions.domain.model.validation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// Entidade responsável pela intenção transacional
public class TransactionIntent {

    // Conta de origem da operação
    private String sourceAccountId;

    // Identificador do destinatário
    private String destinationIdentifier;

    // Valor da transação
    private BigDecimal amount;

    // Endereço IP da operação
    private String ipAddress;

    // Canal utilizado na transação
    private String channel;

    // Horário da solicitação
    private LocalDateTime requestedAt;

    public TransactionIntent() {
        this.requestedAt = LocalDateTime.now();
    }

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(String sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public String getDestinationIdentifier() {
        return destinationIdentifier;
    }

    public void setDestinationIdentifier(String destinationIdentifier) {
        this.destinationIdentifier = destinationIdentifier;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }
}
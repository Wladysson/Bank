package com.bank.transactions.infrastructure.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// Entidade JPA responsável pelas transações
@Entity
@Table(name = "transactions")
public class TransactionEntity extends PanacheEntityBase {

    // Identificador único da transação
    @Id
    @Column(name = "transaction_id", nullable = false, unique = true)
    public String transactionId;

    // Tipo da transação
    @Column(name = "transaction_type", nullable = false)
    public String transactionType;

    // Status atual da transação
    @Column(name = "status", nullable = false)
    public String status;

    // Valor monetário
    @Column(name = "amount", nullable = false)
    public BigDecimal amount;

    // Moeda utilizada
    @Column(name = "currency", nullable = false)
    public String currency;

    // Canal da operação
    @Column(name = "channel")
    public String channel;

    // Código autenticador
    @Column(name = "authentication_code")
    public String authenticationCode;

    // Data de criação
    @Column(name = "created_at")
    public LocalDateTime createdAt;

    // Data de conclusão
    @Column(name = "completed_at")
    public LocalDateTime completedAt;
}
package com.bank.transactions.infrastructure.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;

// Entidade JPA responsável pelos comprovantes
@Entity
@Table(name = "receipts")
public class ReceiptEntity extends PanacheEntityBase {

    // Identificador do comprovante
    @Id
    @Column(name = "receipt_id", nullable = false, unique = true)
    public String receiptId;

    // Identificador da transação
    @Column(name = "transaction_id")
    public String transactionId;

    // URL do comprovante
    @Column(name = "receipt_url")
    public String receiptUrl;

    // Data de geração
    @Column(name = "generated_at")
    public LocalDateTime generatedAt;
}
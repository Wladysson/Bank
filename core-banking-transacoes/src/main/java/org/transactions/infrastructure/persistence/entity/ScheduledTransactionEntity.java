package com.bank.transactions.infrastructure.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// Entidade JPA responsável pelos agendamentos
@Entity
@Table(name = "scheduled_transactions")
public class ScheduledTransactionEntity extends PanacheEntityBase {

    // Identificador do agendamento
    @Id
    @Column(name = "schedule_id", nullable = false, unique = true)
    public String scheduleId;

    // Conta de origem
    @Column(name = "source_account_id")
    public String sourceAccountId;

    // Identificador do destinatário
    @Column(name = "destination_identifier")
    public String destinationIdentifier;

    // Valor da operação
    @Column(name = "amount")
    public BigDecimal amount;

    // Status do agendamento
    @Column(name = "status")
    public String status;

    // Data programada
    @Column(name = "scheduled_at")
    public LocalDateTime scheduledAt;

    // Quantidade de tentativas
    @Column(name = "retry_count")
    public Integer retryCount;
}
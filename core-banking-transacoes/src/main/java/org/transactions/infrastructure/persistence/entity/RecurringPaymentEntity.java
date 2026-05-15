package com.bank.transactions.infrastructure.persistence.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

// Entidade JPA responsável pelos pagamentos recorrentes
@Entity
@Table(name = "recurring_payments")
public class RecurringPaymentEntity extends PanacheEntityBase {

    // Identificador da recorrência
    @Id
    @Column(name = "recurring_payment_id", nullable = false, unique = true)
    public String recurringPaymentId;

    // Conta de origem
    @Column(name = "source_account_id")
    public String sourceAccountId;

    // Identificador do destinatário
    @Column(name = "destination_identifier")
    public String destinationIdentifier;

    // Valor recorrente
    @Column(name = "amount")
    public BigDecimal amount;

    // Frequência da recorrência
    @Column(name = "frequency")
    public String frequency;

    // Status da recorrência
    @Column(name = "status")
    public String status;

    // Data inicial
    @Column(name = "start_date")
    public LocalDate startDate;

    // Próxima execução
    @Column(name = "next_execution_date")
    public LocalDate nextExecutionDate;

    // Data final
    @Column(name = "end_date")
    public LocalDate endDate;
}
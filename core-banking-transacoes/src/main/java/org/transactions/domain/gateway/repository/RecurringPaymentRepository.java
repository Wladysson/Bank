package com.bank.transactions.domain.gateway.repository;

import com.bank.transactions.domain.model.recurring.RecurringPayment;

import java.util.List;
import java.util.Optional;

// Repositório responsável pelos pagamentos recorrentes
public interface RecurringPaymentRepository {

    // Persiste recorrência
    RecurringPayment save(RecurringPayment recurringPayment);

    // Busca recorrência pelo identificador
    Optional<RecurringPayment> findById(String recurringPaymentId);

    // Lista recorrências ativas
    List<RecurringPayment> findActivePayments();
}
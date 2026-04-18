package com.bank.payments.infrastructure.persistence.repository;

import com.bank.payments.domain.model.BatchPayment;
import com.bank.payments.domain.repository.BatchRepository;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class BatchRepositoryImpl implements BatchRepository {

    @Override
    public void save(BatchPayment batch) {}

    @Override
    public Optional<BatchPayment> findById(String id) {
        return Optional.empty();
    }
}
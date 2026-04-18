package com.bank.payments.domain.repository;

import com.bank.payments.domain.model.BatchPayment;

import java.util.Optional;

public interface BatchRepository {

    void save(BatchPayment batch);

    Optional<BatchPayment> findById(String id);
}
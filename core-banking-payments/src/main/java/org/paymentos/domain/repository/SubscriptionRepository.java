package com.bank.payments.domain.repository;

import com.bank.payments.domain.model.Subscription;

import java.time.LocalDate;
import java.util.List;

public interface SubscriptionRepository {

    void save(Subscription subscription);

    Subscription findById(String id);

    List<Subscription> findByUserId(String userId);

    List<Subscription> findActiveDueSubscriptions(LocalDate date);

    void update(Subscription subscription);
}
package com.bank.payments.infrastructure.persistence.repository;

import com.bank.payments.domain.model.Subscription;
import com.bank.payments.domain.repository.SubscriptionRepository;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class SubscriptionRepositoryImpl implements SubscriptionRepository {

    @Override
    public void save(Subscription subscription) {}

    @Override
    public Subscription findById(String id) { return null; }

    @Override
    public List<Subscription> findByUserId(String userId) { return List.of(); }

    @Override
    public List<Subscription> findActiveDueSubscriptions(LocalDate date) {
        return List.of();
    }

    @Override
    public void update(Subscription subscription) {}
}
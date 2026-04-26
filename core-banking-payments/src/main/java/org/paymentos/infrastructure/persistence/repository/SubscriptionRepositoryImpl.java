package com.bank.payments.infrastructure.persistence.repository;

import com.bank.payments.domain.model.Subscription;
import com.bank.payments.domain.model.SubscriptionPayment;
import com.bank.payments.domain.repository.SubscriptionRepository;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class SubscriptionRepositoryImpl implements SubscriptionRepository {

    private final List<Subscription> subscriptions = new ArrayList<>();
    private final List<SubscriptionPayment> payments = new ArrayList<>();

    @Override
    public void save(Subscription subscription) {
        subscriptions.add(subscription);
    }

    @Override
    public Subscription findById(String id) {
        return subscriptions.stream()
                .filter(subscription -> subscription.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Subscription> findByUserId(String userId) {
        return subscriptions.stream()
                .filter(subscription -> subscription.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Subscription> findActiveDueSubscriptions(LocalDate date) {
        return subscriptions.stream()
                .filter(subscription ->
                        subscription.isActive() &&
                                subscription.getNextExecutionDate() != null &&
                                !subscription.getNextExecutionDate().isAfter(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<SubscriptionPayment> findPaymentsBySubscriptionId(String subscriptionId) {
        return payments.stream()
                .filter(payment -> payment.getSubscriptionId().equals(subscriptionId))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Subscription subscription) {
        for (int i = 0; i < subscriptions.size(); i++) {
            if (subscriptions.get(i).getId().equals(subscription.getId())) {
                subscriptions.set(i, subscription);
                return;
            }
        }

        throw new IllegalArgumentException(
                "Assinatura não encontrada: " + subscription.getId()
        );
    }
}
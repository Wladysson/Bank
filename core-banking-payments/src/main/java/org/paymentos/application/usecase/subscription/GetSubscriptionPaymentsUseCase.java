package com.bank.payments.application.usecase.subscription;

import com.bank.payments.domain.model.SubscriptionPayment;
import com.bank.payments.domain.repository.SubscriptionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GetSubscriptionPaymentsUseCase {

    @Inject
    SubscriptionRepository repository;

    public List<SubscriptionPayment> execute(String subscriptionId) {
        return repository.findPaymentsBySubscriptionId(subscriptionId);
    }
}
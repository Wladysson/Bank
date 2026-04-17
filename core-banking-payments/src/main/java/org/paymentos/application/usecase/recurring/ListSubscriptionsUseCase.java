package com.bank.payments.application.usecase.recurring;

import com.bank.payments.application.dto.response.SubscriptionResponse;
import com.bank.payments.domain.repository.SubscriptionRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ListSubscriptionsUseCase {

    @Inject
    SubscriptionRepository subscriptionRepository;

    public List<SubscriptionResponse> execute(String userId) {

        return subscriptionRepository.findByUserId(userId)
                .stream()
                .map(SubscriptionResponse::from)
                .collect(Collectors.toList());
    }
}
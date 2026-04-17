package com.bank.payments.application.usecase.recurring;

import com.bank.payments.application.dto.request.SubscriptionRequest;
import com.bank.payments.application.dto.response.SubscriptionResponse;
import com.bank.payments.domain.model.Subscription;
import com.bank.payments.domain.repository.SubscriptionRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDate;

@ApplicationScoped
public class CreateSubscriptionUseCase {

    @Inject
    SubscriptionRepository subscriptionRepository;

    @Transactional
    public SubscriptionResponse execute(SubscriptionRequest request) {

        Subscription subscription = new Subscription();
        subscription.setUserId(request.getUserId());
        subscription.setAmount(request.getAmount());
        subscription.setCurrency(request.getCurrency());
        subscription.setFrequency(request.getFrequency());
        subscription.setNextExecutionDate(LocalDate.now().plusDays(request.getFrequencyInDays()));
        subscription.setActive(true);

        subscriptionRepository.save(subscription);

        return SubscriptionResponse.from(subscription);
    }
}
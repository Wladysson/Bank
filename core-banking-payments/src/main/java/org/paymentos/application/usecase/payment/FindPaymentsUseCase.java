package com.bank.payments.application.usecase.payment;

import com.bank.payments.domain.model.Payment;
import com.bank.payments.domain.repository.PaymentRepository;
import com.bank.payments.application.dto.response.PaymentResponse;
import com.bank.payments.application.mapper.PaymentMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class FindPaymentsUseCase {

    @Inject
    PaymentRepository repository;

    @Inject
    PaymentMapper mapper;

    public List<PaymentResponse> execute(
            String status,
            String userId,
            LocalDateTime from,
            LocalDateTime to
    ) {

        List<Payment> payments = repository.findWithFilters(
                status,
                userId,
                from,
                to
        );

        return payments.stream()
                .map(mapper::toResponse)
                .toList();
    }
}
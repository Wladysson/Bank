package com.bank.payments.application.usecase.gateway;

import com.bank.payments.application.service.PaymentRoutingService;
import com.bank.payments.domain.model.Payment;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RoutePaymentToGatewayUseCase {

    @Inject
    PaymentRoutingService routingService;

    public void execute(Payment payment) {
        routingService.route(payment);
    }
}
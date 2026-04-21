package com.bank.payments.interfaces.graphql;

import com.bank.payments.application.dto.response.PaymentResponse;
import com.bank.payments.application.usecase.payment.GetPaymentStatusUseCase;

import jakarta.inject.Inject;

import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Name;

public class PaymentGraphQLResource {

    @Inject
    GetPaymentStatusUseCase useCase;

    @Query("payment")
    public PaymentResponse getPayment(@Name("id") String id) {
        return useCase.execute(id);
    }
}
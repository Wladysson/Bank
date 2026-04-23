package com.bank.payments.interfaces.graphql;

import com.bank.payments.application.dto.response.PaymentStatusResponse;
import com.bank.payments.application.usecase.payment.GetPaymentStatusUseCase;

import jakarta.inject.Inject;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.GraphQLApi;

@GraphQLApi
public class PaymentGraphQLResource {

    @Inject
    GetPaymentStatusUseCase useCase;

    @Query("payment")
    public PaymentStatusResponse getPayment(@Name("id") String id) {
        return useCase.execute(id);
    }
}
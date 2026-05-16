package com.bank.transactions.interfaces.rest.resource.v1;

import com.bank.transactions.application.dto.request.recurring.CreateRecurringPaymentRequest;
import com.bank.transactions.application.dto.response.recurring.RecurringPaymentResponse;
import com.bank.transactions.application.usecase.recurring.CreateRecurringPaymentUseCase;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

// Resource responsável pelos pagamentos recorrentes
@Path("/v1/recurring-payments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RecurringPaymentResource {

    @Inject
    CreateRecurringPaymentUseCase createRecurringPaymentUseCase;

    // Cria recorrência financeira
    @POST
    public RecurringPaymentResponse create(
            CreateRecurringPaymentRequest request
    ) {

        return createRecurringPaymentUseCase.execute(request);
    }
}
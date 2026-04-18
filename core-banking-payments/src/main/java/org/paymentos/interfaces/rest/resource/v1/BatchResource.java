package com.bank.payments.interfaces.rest.resource.v1;

import com.bank.payments.application.dto.request.BatchPaymentRequest;
import com.bank.payments.application.dto.response.BatchResponse;
import com.bank.payments.application.usecase.batch.ProcessBatchPaymentsUseCase;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/api/v1/batch")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BatchResource {

    @Inject
    ProcessBatchPaymentsUseCase useCase;

    @POST
    public BatchResponse process(BatchPaymentRequest request) {
        return useCase.execute(request);
    }
}
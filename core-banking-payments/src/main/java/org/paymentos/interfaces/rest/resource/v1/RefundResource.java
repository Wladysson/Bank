package com.bank.payments.interfaces.rest.resource.v1;

import com.bank.payments.application.dto.request.RefundRequest;
import com.bank.payments.application.usecase.payment.RefundPaymentUseCase;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/api/v1/refund")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RefundResource {

    @Inject
    RefundPaymentUseCase useCase;

    @POST
    public void refund(RefundRequest request) {
        useCase.execute(request);
    }
}
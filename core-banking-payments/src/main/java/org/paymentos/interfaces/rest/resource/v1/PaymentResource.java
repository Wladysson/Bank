package com.bank.payments.interfaces.rest.resource.v1;

import com.bank.payments.application.dto.request.PaymentRequest;
import com.bank.payments.application.dto.response.PaymentResponse;
import com.bank.payments.application.usecase.payment.ProcessPaymentUseCase;
import com.bank.payments.application.usecase.payment.GetPaymentStatusUseCase;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/api/v1/payments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaymentResource {

    @Inject
    ProcessPaymentUseCase processUseCase;

    @Inject
    GetPaymentStatusUseCase statusUseCase;

    @POST
    public PaymentResponse process(PaymentRequest request) {
        return processUseCase.execute(request);
    }

    @GET
    @Path("/{id}")
    public PaymentResponse getStatus(@PathParam("id") String id) {
        return statusUseCase.execute(id);
    }
}
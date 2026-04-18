package com.bank.payments.interfaces.rest.resource.v1;

import com.bank.payments.application.dto.request.BoletoPaymentRequest;
import com.bank.payments.application.dto.response.PaymentResponse;
import com.bank.payments.application.usecase.boleto.ProcessBoletoPaymentUseCase;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/api/v1/boleto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BoletoResource {

    @Inject
    ProcessBoletoPaymentUseCase useCase;

    @POST
    public PaymentResponse process(BoletoPaymentRequest request) {
        return useCase.execute(request);
    }
}
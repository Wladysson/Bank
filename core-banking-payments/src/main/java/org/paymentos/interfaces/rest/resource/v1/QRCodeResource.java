package com.bank.payments.interfaces.rest.resource.v1;

import com.bank.payments.application.dto.request.QRCodePaymentRequest;
import com.bank.payments.application.dto.response.PaymentResponse;
import com.bank.payments.application.usecase.qrcode.ProcessQRCodePaymentUseCase;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/api/v1/qrcode")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QRCodeResource {

    @Inject
    ProcessQRCodePaymentUseCase useCase;

    @POST
    public PaymentResponse process(QRCodePaymentRequest request) {
        return useCase.execute(request);
    }
}
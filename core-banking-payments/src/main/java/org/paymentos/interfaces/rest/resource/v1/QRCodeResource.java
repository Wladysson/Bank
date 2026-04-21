package com.bank.payments.interfaces.rest.resource.v1;

import com.bank.payments.application.dto.request.QRCodePaymentRequest;
import com.bank.payments.application.dto.response.PaymentResponse;
import com.bank.payments.application.usecase.qrcode.ProcessQRCodePaymentUseCase;
import com.bank.payments.domain.model.PaymentStatus;

import java.math.BigDecimal;

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

        ProcessQRCodePaymentUseCase.PaymentResult result =
                useCase.execute(
                        request.getPayerId(),
                        new BigDecimal(request.getQrCode())
                );

        return new PaymentResponse(
                result.getPaymentId(),
                PaymentStatus.valueOf(result.getStatus()),
                result.getAmount(),
                "BRL",                // default pra não quebrar
                "QR Code Payment"     // default pra não quebrar
        );
    }
}
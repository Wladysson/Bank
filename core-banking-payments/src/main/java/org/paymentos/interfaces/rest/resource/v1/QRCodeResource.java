package com.bank.payments.interfaces.rest.resource.v1;

import com.bank.payments.application.dto.request.QRCodePaymentRequest;
import com.bank.payments.application.dto.response.PaymentResponse;
import com.bank.payments.application.dto.response.QRCodeStatusResponse;
import com.bank.payments.application.service.QrCodeService;
import com.bank.payments.application.usecase.qrcode.ProcessQRCodePaymentUseCase;
import com.bank.payments.domain.model.PaymentStatus;
import com.bank.payments.domain.model.QRCode;

import java.math.BigDecimal;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/qrcode")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QRCodeResource {

    @Inject
    ProcessQRCodePaymentUseCase useCase;

    @Inject
    QrCodeService service;

    @POST
    public PaymentResponse process(QRCodePaymentRequest request) {

        var result = useCase.execute(
                request.getPayerId(),
                new BigDecimal(request.getQrCode())
        );

        return new PaymentResponse(
                result.getPaymentId(),
                PaymentStatus.valueOf(result.getStatus()),
                result.getAmount(),
                "BRL",
                "QR Code Payment"
        );
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") String id) {
        QRCode qr = service.findById(id);
        return Response.ok(qr).build();
    }

    @GET
    @Path("/status/{id}")
    public Response getStatus(@PathParam("id") String id) {
        QRCodeStatusResponse status = service.getStatus(id);
        return Response.ok(status).build();
    }
}
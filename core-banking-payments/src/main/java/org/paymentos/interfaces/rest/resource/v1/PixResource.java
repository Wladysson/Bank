package com.bank.payments.interfaces.rest.resource.v1;

import com.bank.payments.application.dto.request.PixPaymentRequest;
import com.bank.payments.application.dto.request.PixQRCodeRequest;
import com.bank.payments.application.dto.request.PixRefundRequest;
import com.bank.payments.application.dto.response.PixPaymentResponse;
import com.bank.payments.application.dto.response.PixQRCodeResponse;
import com.bank.payments.application.usecase.pix.ConfirmPixPaymentUseCase;
import com.bank.payments.application.usecase.pix.CreatePixPaymentUseCase;
import com.bank.payments.application.usecase.pix.GeneratePixQRCodeUseCase;
import com.bank.payments.application.usecase.pix.GetPixStatusUseCase;
import com.bank.payments.application.usecase.pix.RefundPixUseCase;
import com.bank.payments.application.usecase.pix.ValidatePixKeyUseCase;
import com.bank.payments.domain.model.PixKey;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.net.URI;
import java.util.Map;
import java.util.UUID;

@Path("/api/v1/pix")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PixResource {

    private final CreatePixPaymentUseCase createPixPaymentUseCase;
    private final ConfirmPixPaymentUseCase confirmPixPaymentUseCase;
    private final GeneratePixQRCodeUseCase generatePixQRCodeUseCase;
    private final ValidatePixKeyUseCase validatePixKeyUseCase;
    private final RefundPixUseCase refundPixUseCase;
    private final GetPixStatusUseCase getPixStatusUseCase;

    @Inject
    public PixResource(
            CreatePixPaymentUseCase createPixPaymentUseCase,
            ConfirmPixPaymentUseCase confirmPixPaymentUseCase,
            GeneratePixQRCodeUseCase generatePixQRCodeUseCase,
            ValidatePixKeyUseCase validatePixKeyUseCase,
            RefundPixUseCase refundPixUseCase,
            GetPixStatusUseCase getPixStatusUseCase
    ) {
        this.createPixPaymentUseCase = createPixPaymentUseCase;
        this.confirmPixPaymentUseCase = confirmPixPaymentUseCase;
        this.generatePixQRCodeUseCase = generatePixQRCodeUseCase;
        this.validatePixKeyUseCase = validatePixKeyUseCase;
        this.refundPixUseCase = refundPixUseCase;
        this.getPixStatusUseCase = getPixStatusUseCase;
    }

    @POST
    @Path("/payments")
    public Response createPayment(
            @Valid PixPaymentRequest request,
            @Context UriInfo uriInfo
    ) {
        PixPaymentResponse response = createPixPaymentUseCase.execute(request);

        URI location = uriInfo.getAbsolutePathBuilder()
                .path(response.id().toString())
                .build();

        return Response.created(location)
                .entity(response)
                .build();
    }

    @POST
    @Path("/payments/{paymentId}/confirm")
    public Response confirmPayment(@PathParam("paymentId") UUID paymentId) {
        PixPaymentResponse response = confirmPixPaymentUseCase.execute(paymentId.toString());
        return Response.ok(response).build();
    }

    @GET
    @Path("/payments/{paymentId}")
    public Response getPaymentStatus(@PathParam("paymentId") UUID paymentId) {
        PixPaymentResponse response = getPixStatusUseCase.execute(paymentId.toString());
        return Response.ok(response).build();
    }

    @POST
    @Path("/payments/{paymentId}/refund")
    public Response refundPayment(
            @PathParam("paymentId") UUID paymentId,
            @Valid PixRefundRequest request
    ) {
        PixRefundRequest refundRequest = new PixRefundRequest(
                paymentId,
                request.amount(),
                request.reason(),
                UUID.randomUUID().toString()

        );

        PixPaymentResponse response = refundPixUseCase.execute(refundRequest);
        return Response.ok(response).build();
    }

    @POST
    @Path("/qrcodes")
    public Response generateQrCode(@Valid PixQRCodeRequest request) {
        PixQRCodeResponse response = generatePixQRCodeUseCase.execute(request);
        return Response.ok(response).build();
    }

    @GET
    @Path("/keys/validate")
    public Response validatePixKey(@QueryParam("value") String keyValue) {
        if (keyValue == null || keyValue.isBlank()) {
            throw new BadRequestException("Pix key value must be provided");
        }

        PixKey pixKey = validatePixKeyUseCase.execute(keyValue);

        return Response.ok(Map.of(
                "key", pixKey.getValue(),
                "type", pixKey.getType().name(),
                "masked", pixKey.getMaskedValue()
        )).build();
    }

    @GET
    @Path("/health")
    public Response health() {
        return Response.ok(Map.of(
                "service", "pix-service",
                "status", "UP",
                "version", "v1"
        )).build();
    }
}
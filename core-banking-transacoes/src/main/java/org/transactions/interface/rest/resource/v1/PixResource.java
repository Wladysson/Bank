package com.bank.transactions.interfaces.rest.resource.v1;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.Map;
import java.util.UUID;

@Path("/api/v1/pix")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PixResource {

    private final ExecutePixTransferUseCase executePixTransferUseCase;
    private final ConfirmPixSettlementUseCase confirmPixSettlementUseCase;
    private final GeneratePixQrCodeUseCase generatePixQrCodeUseCase;
    private final ValidatePixKeyUseCase validatePixKeyUseCase;
    private final RefundPixTransactionUseCase refundPixTransactionUseCase;
    private final GetPixTransactionStatusUseCase getPixTransactionStatusUseCase;

    @Inject
    public PixResource(
            ExecutePixTransferUseCase executePixTransferUseCase,
            ConfirmPixSettlementUseCase confirmPixSettlementUseCase,
            GeneratePixQrCodeUseCase generatePixQrCodeUseCase,
            ValidatePixKeyUseCase validatePixKeyUseCase,
            RefundPixTransactionUseCase refundPixTransactionUseCase,
            GetPixTransactionStatusUseCase getPixTransactionStatusUseCase
    ) {

        this.executePixTransferUseCase = executePixTransferUseCase;
        this.confirmPixSettlementUseCase = confirmPixSettlementUseCase;
        this.generatePixQrCodeUseCase = generatePixQrCodeUseCase;
        this.validatePixKeyUseCase = validatePixKeyUseCase;
        this.refundPixTransactionUseCase = refundPixTransactionUseCase;
        this.getPixTransactionStatusUseCase =
                getPixTransactionStatusUseCase;
    }

    /*
     * =========================================================
     * CREATE PIX PAYMENT
     * =========================================================
     */
    @POST
    @Path("/payments")
    public Response createPayment(
            @Valid ExecutePixTransferRequest request,
            @Context UriInfo uriInfo
    ) {

        PixTransactionResponse response =
                executePixTransferUseCase.execute(request);

        URI location = uriInfo.getAbsolutePathBuilder()
                .path(response.transactionId().toString())
                .build();

        return Response.created(location)
                .entity(response)
                .build();
    }

    /*
     * =========================================================
     * CONFIRM PIX PAYMENT
     * =========================================================
     */
    @POST
    @Path("/payments/{paymentId}/confirm")
    public Response confirmPayment(
            @PathParam("paymentId") UUID paymentId
    ) {

        PixTransactionResponse response =
                confirmPixSettlementUseCase.execute(
                        paymentId.toString()
                );

        return Response.ok(response).build();
    }

    /*
     * =========================================================
     * GET PAYMENT STATUS
     * =========================================================
     */
    @GET
    @Path("/payments/{paymentId}")
    public Response getPaymentStatus(
            @PathParam("paymentId") UUID paymentId
    ) {

        PixTransactionResponse response =
                getPixTransactionStatusUseCase.execute(
                        paymentId.toString()
                );

        return Response.ok(response).build();
    }

    /*
     * =========================================================
     * REFUND PAYMENT
     * =========================================================
     */
    @POST
    @Path("/payments/{paymentId}/refund")
    public Response refundPayment(
            @PathParam("paymentId") UUID paymentId,
            @Valid RefundPixTransactionRequest request
    ) {

        RefundPixTransactionRequest refundRequest =
                new RefundPixTransactionRequest(
                        paymentId,
                        request.amount(),
                        request.reason(),
                        UUID.randomUUID().toString()
                );

        PixTransactionResponse response =
                refundPixTransactionUseCase.execute(refundRequest);

        return Response.ok(response).build();
    }

    /*
     * =========================================================
     * GENERATE QR CODE
     * =========================================================
     */
    @POST
    @Path("/qrcodes")
    public Response generateQrCode(
            @Valid GeneratePixQrCodeRequest request
    ) {

        PixQrCodeResponse response =
                generatePixQrCodeUseCase.execute(request);

        return Response.ok(response).build();
    }

    /*
     * =========================================================
     * VALIDATE PIX KEY
     * =========================================================
     */
    @GET
    @Path("/keys/validate")
    public Response validatePixKey(
            @QueryParam("value") String keyValue
    ) {

        if (keyValue == null || keyValue.isBlank()) {
            throw new BadRequestException(
                    "Pix key value must be provided"
            );
        }

        PixKey pixKey =
                validatePixKeyUseCase.execute(keyValue);

        return Response.ok(
                Map.of(
                        "key", pixKey.getValue(),
                        "type", pixKey.getType().name(),
                        "masked", pixKey.getMaskedValue()
                )
        ).build();
    }

    /*
     * =========================================================
     * HEALTH CHECK  
     * =========================================================
     */
    @GET
    @Path("/health")
    public Response health() {

        return Response.ok(
                Map.of(
                        "service", "transactions-pix-service",
                        "status", "UP",
                        "version", "v1"
                )
        ).build();
    }
}
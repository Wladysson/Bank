package com.bank.payments.interfaces.rest.resource.v1;

import com.bank.payments.application.dto.request.BoletoPaymentRequest;
import com.bank.payments.application.dto.response.BoletoResponse;
import com.bank.payments.application.dto.response.PaymentResponse;
import com.bank.payments.application.usecase.boleto.CancelBoletoUseCase;
import com.bank.payments.application.usecase.boleto.GetBoletoPdfUseCase;
import com.bank.payments.application.usecase.boleto.GetBoletoUseCase;
import com.bank.payments.application.usecase.boleto.ProcessBoletoPaymentUseCase;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/boleto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BoletoResource {

    @Inject
    ProcessBoletoPaymentUseCase useCase;

    @Inject
    GetBoletoUseCase getUseCase;

    @Inject
    CancelBoletoUseCase cancelUseCase;

    @Inject
    GetBoletoPdfUseCase pdfUseCase;

    @POST
    public Response process(BoletoPaymentRequest request) {
        PaymentResponse response = useCase.execute(request);
        return Response.status(Response.Status.CREATED)
                .entity(response)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") String id) {
        BoletoResponse response = BoletoResponse.from(getUseCase.execute(id));
        return Response.ok(response).build();
    }

    // =========================
    // CANCEL BOLETO
    // =========================
    @POST
    @Path("/{id}/cancel")
    public Response cancel(@PathParam("id") String id) {
        BoletoResponse response = BoletoResponse.from(cancelUseCase.execute(id));
        return Response.ok(response).build();
    }

    // =========================
    // PDF BOLETO
    // =========================
    @GET
    @Path("/{id}/pdf")
    @Produces("application/pdf")
    public Response pdf(@PathParam("id") String id) {
        byte[] pdf = pdfUseCase.execute(id);

        return Response.ok(pdf)
                .header("Content-Disposition", "inline; filename=\"boleto-" + id + ".pdf\"")
                .build();
    }
}
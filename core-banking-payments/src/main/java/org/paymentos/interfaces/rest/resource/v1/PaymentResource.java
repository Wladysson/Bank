package com.bank.payments.interfaces.rest.resource.v1;

import com.bank.payments.application.dto.request.PaymentRequest;
import com.bank.payments.application.dto.response.PaymentResponse;
import com.bank.payments.application.usecase.payment.ProcessPaymentUseCase;
import com.bank.payments.application.usecase.payment.GetPaymentStatusUseCase;
import com.bank.payments.application.dto.response.PaymentStatusResponse;
import com.bank.payments.application.usecase.payment.ProcessPaymentCommand;
import com.bank.payments.application.usecase.payment.FindPaymentsUseCase;
import java.util.List;
import java.time.LocalDateTime;

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

    @Inject
    FindPaymentsUseCase findPaymentsUseCase;

    @POST
    public PaymentResponse process(PaymentRequest request) {

        ProcessPaymentCommand command = new ProcessPaymentCommand(
                null,
                request.getPayerId(),
                request.getAmount(),
                request.getDescription(),
                request.getMethod(),
                request.getType(),
                request.getPayerId(),
                request.getPayeeId()
        );

        return processUseCase.execute(command);
    }

    @GET
    @Path("/{id}")
    public PaymentStatusResponse getStatus(@PathParam("id") String id) {
        return statusUseCase.execute(id);
    }

    @GET
    public List<PaymentResponse> findPayments(
            @QueryParam("status") String status,
            @QueryParam("userId") String userId,
            @QueryParam("from") String from,
            @QueryParam("to") String to
    ) {

        return findPaymentsUseCase.execute(
                status,
                userId,
                parseDate(from),
                parseDate(to)
        );
    }

    private LocalDateTime parseDate(String value) {
        if (value == null) return null;
        return LocalDateTime.parse(value);
    }

}
package com.bank.payments.interfaces.rest.resource.v1;

import com.bank.payments.application.dto.request.PaymentRequest;
import com.bank.payments.application.dto.response.PaymentResponse;
import com.bank.payments.application.usecase.payment.ProcessPaymentUseCase;
import com.bank.payments.application.usecase.payment.GetPaymentStatusUseCase;
import com.bank.payments.application.dto.response.PaymentStatusResponse;
import com.bank.payments.application.usecase.payment.ProcessPaymentCommand;
import com.bank.payments.application.usecase.payment.FindPaymentsUseCase;
import com.bank.payments.application.usecase.payment.CancelPaymentUseCase;
import com.bank.payments.application.usecase.payment.RetryPaymentUseCase;
import com.bank.payments.application.usecase.payment.ConfirmPaymentUseCase;
import com.bank.payments.application.mapper.PaymentMapper;
import com.bank.payments.domain.model.Payment;

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
    PaymentMapper mapper;

    @Inject
    ProcessPaymentUseCase processUseCase;

    @Inject
    GetPaymentStatusUseCase statusUseCase;

    @Inject
    FindPaymentsUseCase findPaymentsUseCase;

    @Inject
    CancelPaymentUseCase cancelPaymentUseCase;

    @Inject
    RetryPaymentUseCase retryPaymentUseCase;

    @Inject
    ConfirmPaymentUseCase confirmPaymentUseCase;

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

    @POST
    @Path("/{id}/cancel")
    public PaymentResponse cancel(@PathParam("id") String id) {
        Payment payment = cancelPaymentUseCase.execute(id);
        return mapper.toResponse(payment);
    }

    @POST
    @Path("/{id}/retry")
    public PaymentResponse retry(@PathParam("id") String id) {
        Payment payment = retryPaymentUseCase.execute(id);
        return mapper.toResponse(payment);
    }

    @POST
    @Path("/{id}/confirm")
    public PaymentResponse confirm(@PathParam("id") String id) {
        Payment payment = confirmPaymentUseCase.execute(id);
        return mapper.toResponse(payment);
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
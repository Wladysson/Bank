package com.bank.payments.interfaces.rest.exception;

import com.bank.payments.domain.exception.InsufficientFundsException;
import com.bank.payments.domain.exception.PaymentDomainException;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception ex) {

        if (ex instanceof InsufficientFundsException) {
            return Response.status(400)
                    .entity(ExceptionUtils.build(
                            ErrorCode.INSUFFICIENT_FUNDS,
                            ex.getMessage()))
                    .build();
        }

        if (ex instanceof PaymentDomainException) {
            return Response.status(422)
                    .entity(ExceptionUtils.build(
                            ErrorCode.PAYMENT_FAILED,
                            ex.getMessage()))
                    .build();
        }

        if (ex instanceof IllegalArgumentException) {
            return Response.status(400)
                    .entity(ExceptionUtils.build(
                            ErrorCode.VALIDATION_ERROR,
                            ex.getMessage()))
                    .build();
        }

        // fallback
        return Response.status(500)
                .entity(ExceptionUtils.build(
                        ErrorCode.INTERNAL_ERROR,
                        "Erro interno inesperado"))
                .build();
    }
}
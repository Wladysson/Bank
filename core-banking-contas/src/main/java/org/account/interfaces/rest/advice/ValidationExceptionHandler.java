package com.bank.account.interfaces.rest.advice;

import com.bank.account.interfaces.rest.response.ApiErrorResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.List;

@Provider
public class ValidationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {

    @Context
    ContainerRequestContext requestContext;

    @Override
    public Response toResponse(
            ConstraintViolationException exception
    ) {

        List<String> details =
                exception.getConstraintViolations()
                        .stream()
                        .map(this::formatViolation)
                        .toList(); // converte violações em mensagens amigáveis

        ApiErrorResponse error =
                ApiErrorMapper.validation(
                        "Validation failed",
                        requestContext.getUriInfo().getPath(),
                        details
                );

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(error)
                .build();
    }

    private String formatViolation(
            ConstraintViolation<?> violation
    ) {

        return violation.getPropertyPath()
                + " "
                + violation.getMessage(); // formata mensagem de validação
    }
}
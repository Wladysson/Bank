package com.bank.account.interfaces.rest.advice;

import com.bank.account.domain.exception.AccountNotFoundException;
import com.bank.account.domain.exception.InvalidAccountStatusTransitionException;
import com.bank.account.domain.exception.JointHolderValidationException;
import com.bank.account.interfaces.rest.response.ApiErrorResponse;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class AccountExceptionHandler implements ExceptionMapper<RuntimeException> {

    @Context
    ContainerRequestContext requestContext;

    @Override
    public Response toResponse(RuntimeException exception) {

        if (exception instanceof AccountNotFoundException) {

            ApiErrorResponse error =
                    ApiErrorMapper.notFound(
                            exception.getMessage(),
                            requestContext.getUriInfo().getPath()
                    ); // monta resposta para conta não encontrada

            return Response.status(Response.Status.NOT_FOUND)
                    .entity(error)
                    .build();
        }

        if (exception instanceof InvalidAccountStatusTransitionException) {

            ApiErrorResponse error =
                    ApiErrorMapper.business(
                            "INVALID_ACCOUNT_STATUS_TRANSITION",
                            exception.getMessage(),
                            requestContext.getUriInfo().getPath()
                    ); // monta resposta para transição inválida

            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(error)
                    .build();
        }

        if (exception instanceof JointHolderValidationException) {

            ApiErrorResponse error =
                    ApiErrorMapper.business(
                            "JOINT_HOLDER_VALIDATION_ERROR",
                            exception.getMessage(),
                            requestContext.getUriInfo().getPath()
                    ); // monta resposta para erro de cotitularidade

            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(error)
                    .build();
        }

        ApiErrorResponse error =
                ApiErrorMapper.internal(
                        exception.getMessage(),
                        requestContext.getUriInfo().getPath()
                ); // trata erros inesperados

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(error)
                .build();
    }
}
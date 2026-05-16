package com.bank.transactions.interfaces.rest.exception;

import com.bank.transactions.domain.exception.BankTransferWindowClosedException;
import com.bank.transactions.domain.exception.ExchangeRateUnavailableException;
import com.bank.transactions.domain.exception.InsufficientBalanceException;
import com.bank.transactions.domain.exception.InvalidPixKeyException;
import com.bank.transactions.domain.exception.ScheduleExecutionException;
import com.bank.transactions.domain.exception.TransactionException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

// Handler global responsável pelo tratamento de exceções REST
@Provider
public class GlobalExceptionHandler
        implements ExceptionMapper<Exception> {

    // Intercepta exceções da aplicação
    @Override
    public Response toResponse(Exception exception) {

        if (exception instanceof InsufficientBalanceException) {
            return buildResponse(
                    Response.Status.BAD_REQUEST,
                    exception.getMessage()
            );
        }

        if (exception instanceof InvalidPixKeyException) {
            return buildResponse(
                    Response.Status.BAD_REQUEST,
                    exception.getMessage()
            );
        }

        if (exception instanceof BankTransferWindowClosedException) {
            return buildResponse(
                    Response.Status.CONFLICT,
                    exception.getMessage()
            );
        }

        if (exception instanceof ScheduleExecutionException) {
            return buildResponse(
                    Response.Status.INTERNAL_SERVER_ERROR,
                    exception.getMessage()
            );
        }

        if (exception instanceof ExchangeRateUnavailableException) {
            return buildResponse(
                    Response.Status.SERVICE_UNAVAILABLE,
                    exception.getMessage()
            );
        }

        if (exception instanceof TransactionException) {
            return buildResponse(
                    Response.Status.BAD_REQUEST,
                    exception.getMessage()
            );
        }

        // Trata erros genéricos não mapeados
        return buildResponse(
                Response.Status.INTERNAL_SERVER_ERROR,
                "Erro interno inesperado"
        );
    }

    // Monta payload padronizado de erro
    private Response buildResponse(
            Response.Status status,
            String message
    ) {

        Map<String, Object> error = new HashMap<>();

        error.put("timestamp", LocalDateTime.now());
        error.put("status", status.getStatusCode());
        error.put("error", status.getReasonPhrase());
        error.put("message", message);

        return Response.status(status)
                .entity(error)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
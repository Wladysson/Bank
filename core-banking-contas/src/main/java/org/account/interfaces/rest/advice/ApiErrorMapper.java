package com.bank.account.interfaces.rest.advice;

import com.bank.account.interfaces.rest.response.ApiErrorResponse;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public final class ApiErrorMapper {

    private ApiErrorMapper() {
    }

    public static ApiErrorResponse notFound(
            String message,
            String path
    ) {

        return new ApiErrorResponse(
                "RESOURCE_NOT_FOUND",
                message,
                path,
                LocalDateTime.now(),
                Collections.emptyList()
        ); // cria resposta para recurso não encontrado
    }

    public static ApiErrorResponse business(
            String code,
            String message,
            String path
    ) {

        return new ApiErrorResponse(
                code,
                message,
                path,
                LocalDateTime.now(),
                Collections.emptyList()
        ); // cria resposta para erro de negócio
    }

    public static ApiErrorResponse validation(
            String message,
            String path,
            List<String> details
    ) {

        return new ApiErrorResponse(
                "VALIDATION_ERROR",
                message,
                path,
                LocalDateTime.now(),
                details
        ); // cria resposta para erro de validação
    }

    public static ApiErrorResponse internal(
            String message,
            String path
    ) {

        return new ApiErrorResponse(
                "INTERNAL_SERVER_ERROR",
                message,
                path,
                LocalDateTime.now(),
                Collections.emptyList()
        ); // cria resposta para erro interno
    }
}
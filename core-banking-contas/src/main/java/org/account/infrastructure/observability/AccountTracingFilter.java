package com.bank.account.infrastructure.observability;

import io.vertx.ext.web.RoutingContext;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.MDC;

import java.util.UUID;

@ApplicationScoped
public class AccountTracingFilter {

    public static final String CORRELATION_ID = "correlationId";

    public void doFilter(RoutingContext routingContext) {

        String correlationId = routingContext.request().getHeader(CORRELATION_ID);

        if (correlationId == null || correlationId.isBlank()) {
            correlationId = UUID.randomUUID().toString(); // gera id caso não exista
        }

        MDC.put(CORRELATION_ID, correlationId); // adiciona correlation id ao contexto

        routingContext.response().putHeader(
                CORRELATION_ID,
                correlationId
        ); // devolve correlation id para o consumidor

        routingContext.addEndHandler(v -> {
            MDC.remove(CORRELATION_ID); // remove contexto após conclusão
        });

        routingContext.next(); // continua processamento da requisição
    }
}
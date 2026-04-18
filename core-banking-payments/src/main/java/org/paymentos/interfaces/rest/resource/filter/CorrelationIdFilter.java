package com.bank.payments.interfaces.rest.filter;

import jakarta.ws.rs.container.*;
import jakarta.ws.rs.ext.Provider;

import java.util.UUID;

@Provider
public class CorrelationIdFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final String HEADER = "X-Correlation-Id";

    @Override
    public void filter(ContainerRequestContext requestContext) {

        String correlationId = requestContext.getHeaderString(HEADER);

        if (correlationId == null) {
            correlationId = UUID.randomUUID().toString();
        }

        requestContext.setProperty(HEADER, correlationId);
    }

    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) {

        Object correlationId = requestContext.getProperty(HEADER);

        if (correlationId != null) {
            responseContext.getHeaders().add(HEADER, correlationId.toString());
        }
    }
}
package com.bank.payments.interfaces.rest.filter;

import com.bank.payments.infrastructure.idempotency.IdempotencyEntity;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.container.*;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.core.Response;

@Provider
public class IdempotencyFilter implements ContainerRequestFilter {

    private static final String HEADER = "Idempotency-Key";

    @Inject
    EntityManager em;

    @Override
    @Transactional
    public void filter(ContainerRequestContext requestContext) {

        if (!"POST".equals(requestContext.getMethod())) return;

        String key = requestContext.getHeaderString(HEADER);

        if (key == null || key.isBlank()) return;

        IdempotencyEntity existing = em.find(IdempotencyEntity.class, key);

        if (existing != null) {
            requestContext.abortWith(
                    Response.status(Response.Status.CONFLICT)
                            .entity(existing.getResponse())
                            .build()
            );
        }
    }
}
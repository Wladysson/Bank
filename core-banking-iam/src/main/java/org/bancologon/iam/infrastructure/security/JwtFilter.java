package com.corebanking.iam.security;

import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class JwtFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {

        String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            abort(requestContext);
            return;
        }

        String token = authHeader.substring("Bearer ".length());

        try {
            // Aqui o Quarkus valida automaticamente o JWT
            // Se for inválido, lança exceção
        } catch (Exception e) {
            abort(requestContext);
        }
    }

    private void abort(ContainerRequestContext context) {
        context.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Token inválido ou ausente")
                        .build()
        );
    }
}

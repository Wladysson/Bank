package com.bank.payments.infrastructure.config;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
public class SecurityConfig implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {

        String auth = requestContext.getHeaderString("Authorization");

        if (auth == null || !auth.startsWith("Bearer ")) {
            requestContext.abortWith(
                    jakarta.ws.rs.core.Response.status(401).build()
            );
        }

        // aqui depois você valida JWT
    }
}
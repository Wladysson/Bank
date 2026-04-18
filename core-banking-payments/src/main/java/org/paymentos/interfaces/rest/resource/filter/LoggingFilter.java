package com.bank.payments.interfaces.rest.filter;

import jakarta.ws.rs.container.*;
import jakarta.ws.rs.ext.Provider;

@Provider
public class LoggingFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {

        System.out.println(
                "[REQUEST] " +
                        requestContext.getMethod() + " " +
                        requestContext.getUriInfo().getPath()
        );
    }
}
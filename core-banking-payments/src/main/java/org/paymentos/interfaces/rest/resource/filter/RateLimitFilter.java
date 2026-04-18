package com.bank.payments.interfaces.rest.filter;

import jakarta.ws.rs.container.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Provider
public class RateLimitFilter implements ContainerRequestFilter {

    private static final int LIMIT = 100; // requests
    private static final long WINDOW = 60000; // 1 min

    private final Map<String, Counter> requests = new ConcurrentHashMap<>();

    @Override
    public void filter(ContainerRequestContext requestContext) {

        String ip = requestContext.getHeaderString("X-Forwarded-For");

        if (ip == null) {
            ip = requestContext.getUriInfo().getRequestUri().getHost();
        }

        Counter counter = requests.computeIfAbsent(ip, k -> new Counter());

        synchronized (counter) {
            long now = System.currentTimeMillis();

            if (now - counter.startTime > WINDOW) {
                counter.reset(now);
            }

            counter.count++;

            if (counter.count > LIMIT) {
                requestContext.abortWith(
                        Response.status(429)
                                .entity("Rate limit excedido")
                                .build()
                );
            }
        }
    }

    static class Counter {
        int count = 0;
        long startTime = System.currentTimeMillis();

        void reset(long now) {
            count = 0;
            startTime = now;
        }
    }
}
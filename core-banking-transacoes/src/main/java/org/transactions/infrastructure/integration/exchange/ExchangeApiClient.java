package com.bank.transactions.infrastructure.integration.exchange;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Map;

// Cliente REST responsável pela integração cambial
@Path("/exchange")
@RegisterRestClient(configKey = "exchange-api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ExchangeApiClient {

    // Consulta cotação entre moedas
    @GET
    @Path("/quote")
    Map<String, Object> quote(
            @QueryParam("sourceCurrency")
            String sourceCurrency,

            @QueryParam("targetCurrency")
            String targetCurrency
    );

    // Consulta taxa cambial atual
    @GET
    @Path("/rate")
    Map<String, Object> getRate(
            @QueryParam("sourceCurrency")
            String sourceCurrency,

            @QueryParam("targetCurrency")
            String targetCurrency
    );
}
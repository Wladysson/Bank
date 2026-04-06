package com.bank.ledger.interfaces.rest;

import com.bank.ledger.application.service.HistoricalBalanceQueryService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.time.LocalDate;

@Path("/ledger")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LedgerController {

    @Inject
    HistoricalBalanceQueryService balanceService;

    @GET
    @Path("/balance")
    public Response getBalance(
            @QueryParam("accountNumber") String accountNumber,
            @QueryParam("date") String date
    ) {
        if (accountNumber == null || date == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("accountNumber and date are required").build();
        }

        LocalDate referenceDate = LocalDate.parse(date);

        BigDecimal balance = balanceService.getBalance(accountNumber, referenceDate);

        return Response.ok(balance).build();
    }
}
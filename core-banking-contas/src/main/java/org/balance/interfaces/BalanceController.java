package com.bank.account.interfaces.rest;

import com.bank.account.application.dto.BalanceResponseDTO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/accounts/{accountId}/balance")
@Produces(MediaType.APPLICATION_JSON)
public class BalanceController {

    @GET
    public BalanceResponseDTO getBalance(@PathParam("accountId") String accountId) {

        // mock temporário
        BalanceResponseDTO response = new BalanceResponseDTO();
        return response;
    }
}
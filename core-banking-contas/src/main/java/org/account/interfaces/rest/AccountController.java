package com.bank.account.interfaces.rest;

import com.bank.account.application.command.OpenAccountCommand;
import com.bank.account.application.command.BlockAccountCommand;
import com.bank.account.application.command.CloseAccountCommand;
import com.bank.account.application.dto.AccountRequestDTO;
import com.bank.account.application.service.AccountApplicationService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.util.UUID;

@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountController {

    @Inject
    AccountApplicationService service;

    @POST
    public Response openAccount(AccountRequestDTO request) {

        OpenAccountCommand command = new OpenAccountCommand(
                request.getCustomerId(),
                "TEMP_NAME",
                request.getAccountType(),
                request.getInitialDeposit()
        );

        service.openAccount(command);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}/block")
    public Response blockAccount(@PathParam("id") String id) {

        BlockAccountCommand command = new BlockAccountCommand(
                UUID.fromString(id),
                "BLOCKED_BY_USER"
        );

        service.blockAccount(command);

        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response closeAccount(@PathParam("id") String id) {

        CloseAccountCommand command = new CloseAccountCommand(
                UUID.fromString(id),
                "CLOSED_BY_USER"
        );

        service.closeAccount(command);

        return Response.noContent().build();
    }
}
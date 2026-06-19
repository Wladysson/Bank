package com.bank.account.interfaces.rest.controller;

import com.bank.account.application.command.ActivateAccountCommand;
import com.bank.account.application.command.BlockAccountCommand;
import com.bank.account.application.command.ChangeAccountStatusCommand;
import com.bank.account.application.command.SuspendAccountCommand;
import com.bank.account.application.command.UnblockAccountCommand;
import com.bank.account.application.service.AccountStatusApplicationService;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/accounts/admin")
public class AccountAdminController {

    private final AccountStatusApplicationService statusService;

    public AccountAdminController(
            AccountStatusApplicationService statusService
    ) {
        this.statusService = statusService;
    }

    @POST
    @Path("/{accountId}/activate")
    public Response activate(
            @PathParam("accountId") String accountId,
            ActivateAccountCommand command
    ) {

        statusService.activate(command);

        return Response.ok().build();
    }

    @POST
    @Path("/{accountId}/block")
    public Response block(
            @PathParam("accountId") String accountId,
            BlockAccountCommand command
    ) {

        statusService.block(command);

        return Response.ok().build();
    }

    @POST
    @Path("/{accountId}/unblock")
    public Response unblock(
            @PathParam("accountId") String accountId,
            UnblockAccountCommand command
    ) {

        statusService.unblock(command);

        return Response.ok().build();
    }

    @POST
    @Path("/{accountId}/suspend")
    public Response suspend(
            @PathParam("accountId") String accountId,
            SuspendAccountCommand command
    ) {

        statusService.suspend(command);

        return Response.ok().build();
    }

    @POST
    @Path("/{accountId}/status")
    public Response changeStatus(
            @PathParam("accountId") String accountId,
            ChangeAccountStatusCommand command
    ) {

        statusService.changeStatus(command);

        return Response.ok().build();
    }
}
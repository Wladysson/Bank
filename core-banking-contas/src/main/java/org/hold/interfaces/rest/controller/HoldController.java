package com.bank.account.hold.interfaces.rest.controller;

import com.bank.account.application.command.ReleaseHoldCommand;
import com.bank.account.hold.application.command.CancelHoldCommand;
import com.bank.account.hold.application.command.CreateHoldCommand;
import com.bank.account.hold.application.command.ExtendHoldCommand;
import com.bank.account.hold.application.dto.HoldResponseDTO;
import com.bank.account.hold.application.query.GetHoldsByAccountQuery;
import com.bank.account.hold.application.service.HoldApplicationService;
import com.bank.account.hold.interfaces.rest.request.ExtendHoldRequest;
import com.bank.account.hold.interfaces.rest.request.HoldRequest;
import com.bank.account.hold.interfaces.rest.response.HoldListResponse;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/holds")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HoldController {

    @Inject
    HoldApplicationService holdApplicationService;

    @POST
    public Response createHold(@Valid HoldRequest request) {

        CreateHoldCommand command = new CreateHoldCommand(
                request.getAccountId(),
                request.getAmount(),
                request.getReason(),
                request.getExpirationDate(),
                request.getOperationId()
        );

        HoldResponseDTO response = holdApplicationService.createHold(command);

        return Response.status(Response.Status.CREATED)
                .entity(response)
                .build();
    }

    @POST
    @Path("/{holdId}/release")
    public Response releaseHold(
            @PathParam("holdId") String holdId,
            ReleaseHoldCommand command
    ) {

        ReleaseHoldCommand releaseCommand = new ReleaseHoldCommand(
                holdId,
                command.getReason(),
                command.getReleasedBy(),
                command.getOperationId()
        );

        HoldResponseDTO response =
                holdApplicationService.releaseHold(releaseCommand);

        return Response.ok(response).build();
    }

    @POST
    @Path("/{holdId}/extend")
    public Response extendHold(
            @PathParam("holdId") String holdId,
            @Valid ExtendHoldRequest request
    ) {

        ExtendHoldCommand command = new ExtendHoldCommand(
                holdId,
                request.getNewExpirationDate(),
                request.getReason(),
                request.getRequestedBy()
        );

        HoldResponseDTO response =
                holdApplicationService.extendHold(command);

        return Response.ok(response).build();
    }

    @POST
    @Path("/{holdId}/cancel")
    public Response cancelHold(
            @PathParam("holdId") String holdId,
            CancelHoldCommand command
    ) {

        CancelHoldCommand cancelCommand = new CancelHoldCommand(
                holdId,
                command.getReason(),
                command.getCancelledBy()
        );

        HoldResponseDTO response =
                holdApplicationService.cancelHold(cancelCommand);

        return Response.ok(response).build();
    }

    @GET
    @Path("/account/{accountId}")
    public Response getHoldsByAccount(
            @PathParam("accountId") String accountId
    ) {

        GetHoldsByAccountQuery query =
                new GetHoldsByAccountQuery(accountId);

        HoldListResponse response =
                holdApplicationService.getHolds(query);

        return Response.ok(response).build();
    }
}
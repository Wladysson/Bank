package com.bank.account.interfaces.rest.controller;

import com.bank.account.application.service.AccountTimelineService;
import com.bank.account.domain.model.AccountId;
import com.bank.account.domain.model.AccountSnapshot;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.UUID;

@Path("/accounts/timeline")
@Produces(MediaType.APPLICATION_JSON)
public class AccountTimelineController {

    private final AccountTimelineService timelineService;

    public AccountTimelineController(
            AccountTimelineService timelineService
    ) {
        this.timelineService = timelineService;
    }

    @GET
    @Path("/{accountId}")
    public List<AccountSnapshot> getTimeline(
            @PathParam("accountId") String accountId
    ) {

        AccountId id = AccountId.of(
                UUID.fromString(accountId)
        );

        return timelineService.getHistory(id);
    }
}
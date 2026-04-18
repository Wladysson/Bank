package com.bank.payments.interfaces.rest.resource.v1;

import com.bank.payments.application.dto.request.SubscriptionRequest;
import com.bank.payments.application.dto.response.SubscriptionResponse;
import com.bank.payments.application.usecase.recurring.CreateSubscriptionUseCase;
import com.bank.payments.application.usecase.recurring.ListSubscriptionsUseCase;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/api/v1/subscriptions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubscriptionResource {

    @Inject
    CreateSubscriptionUseCase createUseCase;

    @Inject
    ListSubscriptionsUseCase listUseCase;

    @POST
    public SubscriptionResponse create(SubscriptionRequest request) {
        return createUseCase.execute(request);
    }

    @GET
    @Path("/{userId}")
    public List<SubscriptionResponse> list(@PathParam("userId") String userId) {
        return listUseCase.execute(userId);
    }
}
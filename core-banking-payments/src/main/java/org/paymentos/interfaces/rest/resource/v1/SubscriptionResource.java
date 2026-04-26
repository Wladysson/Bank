package com.bank.payments.interfaces.rest;

import com.bank.payments.application.usecase.subscription.CancelSubscriptionUseCase;
import com.bank.payments.application.usecase.subscription.PauseSubscriptionUseCase;
import com.bank.payments.application.usecase.subscription.ResumeSubscriptionUseCase;
import com.bank.payments.application.usecase.subscription.GetSubscriptionPaymentsUseCase;
import com.bank.payments.domain.model.Subscription;
import com.bank.payments.domain.model.SubscriptionPayment;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/subscriptions")
@Produces(MediaType.APPLICATION_JSON)
public class SubscriptionResource {

    @Inject
    CancelSubscriptionUseCase cancelSubscriptionUseCase;

    @Inject
    PauseSubscriptionUseCase pauseSubscriptionUseCase;

    @Inject
    ResumeSubscriptionUseCase resumeSubscriptionUseCase;

    @Inject
    GetSubscriptionPaymentsUseCase getSubscriptionPaymentsUseCase;

    @POST
    @Path("/{id}/cancel")
    public Subscription cancel(@PathParam("id") String id) {
        return cancelSubscriptionUseCase.execute(id);
    }

    @POST
    @Path("/{id}/pause")
    public Subscription pause(@PathParam("id") String id) {
        return pauseSubscriptionUseCase.execute(id);
    }

    @POST
    @Path("/{id}/resume")
    public Subscription resume(@PathParam("id") String id) {
        return resumeSubscriptionUseCase.execute(id);
    }

    @GET
    @Path("/{id}/payments")
    public List<SubscriptionPayment> getPayments(@PathParam("id") String id) {
        return getSubscriptionPaymentsUseCase.execute(id);
    }
}
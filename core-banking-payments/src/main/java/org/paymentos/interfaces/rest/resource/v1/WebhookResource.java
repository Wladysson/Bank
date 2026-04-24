package com.bank.payments.interfaces.rest.resource.v1;

import com.bank.payments.application.usecase.webhook.CreateWebhookSubscriptionUseCase;
import com.bank.payments.application.usecase.webhook.DeleteWebhookSubscriptionUseCase;
import com.bank.payments.application.usecase.webhook.ListWebhookSubscriptionsUseCase;
import com.bank.payments.application.dto.request.WebhookSubscriptionRequest;
import com.bank.payments.application.dto.request.WebhookEventRequest;
import com.bank.payments.application.dto.response.WebhookSubscriptionResponse;
import com.bank.payments.application.mapper.WebhookMapper;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/api/v1/webhook")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WebhookResource {

    // =========================
    // RECEBIMENTO DE EVENTOS
    // =========================

    @POST
    public void receive(WebhookEventRequest request) {
        System.out.println("Webhook recebido: " + request);

        // futuramente:
        // - validar assinatura
        // - processar evento
        // - atualizar pagamento
        // - publicar evento interno
    }

    // =========================
    // SUBSCRIPTIONS
    // =========================

    @Inject
    WebhookMapper mapper;

    @Inject
    ListWebhookSubscriptionsUseCase listUseCase;

    @GET
    @Path("/subscriptions")
    public List<WebhookSubscriptionResponse> list() {
        return listUseCase.execute()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Inject
    CreateWebhookSubscriptionUseCase createUseCase;

    @POST
    @Path("/subscriptions")
    public WebhookSubscriptionResponse create(WebhookSubscriptionRequest request) {
        return mapper.toResponse(
                createUseCase.execute(request.getUrl(), request.getEventType())
        );
    }

    @Inject
    DeleteWebhookSubscriptionUseCase deleteUseCase;

    @DELETE
    @Path("/subscriptions/{id}")
    public void delete(@PathParam("id") String id) {
        deleteUseCase.execute(id);
    }
}
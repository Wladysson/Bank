package com.bank.transactions.infrastructure.integration.pix;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.Map;

// Endpoint responsável pelo recebimento de webhooks PIX
@Path("/webhooks/pix")
@ApplicationScoped
public class PixWebhookReceiver {

    // Recebe notificações de liquidação PIX
    @POST
    public Response receive(
            Map<String, Object> payload
    ) {

        return Response.accepted().build();
    }
}
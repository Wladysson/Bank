package com.bank.payments.interfaces.rest.resource.v1;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/api/v1/webhook")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WebhookResource {

    @POST
    public void receive(String payload) {

        System.out.println("Webhook recebido: " + payload);

        // aqui depois:
        // - validar assinatura
        // - atualizar pagamento
        // - emitir evento
    }
}
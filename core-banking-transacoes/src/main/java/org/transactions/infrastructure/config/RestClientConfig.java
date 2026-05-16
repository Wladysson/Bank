package com.bank.transactions.infrastructure.config;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

// Configurações dos clientes REST externos
@ApplicationScoped
public class RestClientConfig {

    // URL base do serviço PIX
    @ConfigProperty(name = "quarkus.rest-client.pix-api.url")
    String pixApiUrl;

    // URL base do serviço bancário
    @ConfigProperty(name = "quarkus.rest-client.bank-transfer-api.url")
    String bankTransferApiUrl;

    // URL base do serviço cambial
    @ConfigProperty(name = "quarkus.rest-client.exchange-api.url")
    String exchangeApiUrl;

    public String getPixApiUrl() {
        return pixApiUrl;
    }

    public String getBankTransferApiUrl() {
        return bankTransferApiUrl;
    }

    public String getExchangeApiUrl() {
        return exchangeApiUrl;
    }
}
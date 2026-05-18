package com.bank.transactions.infrastructure.integration.exchange;

import com.bank.transactions.domain.gateway.international.ExchangeGateway;
import com.bank.transactions.domain.model.international.ExchangeQuote;
import com.bank.transactions.domain.model.international.ExchangeRate;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

// Implementação do gateway cambial
@ApplicationScoped
public class ExchangeGatewayImpl implements ExchangeGateway {

    @RestClient
    ExchangeApiClient exchangeApiClient;

    // Consulta cotação cambial
    @Override
    public ExchangeQuote quote(
            String sourceCurrency,
            String targetCurrency
    ) {

        Map<String, Object> response =
                exchangeApiClient.quote(
                        sourceCurrency,
                        targetCurrency
                );

        BigDecimal rate =
                new BigDecimal(
                        response.get("rate").toString()
                );

        return new ExchangeQuote(
                sourceCurrency,
                targetCurrency,
                rate,
                LocalDateTime.now()
        );
    }

    // Obtém taxa cambial atual
    @Override
    public ExchangeRate getCurrentRate(
            String sourceCurrency,
            String targetCurrency
    ) {

        Map<String, Object> response =
                exchangeApiClient.getRate(
                        sourceCurrency,
                        targetCurrency
                );

        BigDecimal value =
                new BigDecimal(
                        response.get("value").toString()
                );

        return new ExchangeRate(
                sourceCurrency,
                targetCurrency,
                value
        );
    }
}
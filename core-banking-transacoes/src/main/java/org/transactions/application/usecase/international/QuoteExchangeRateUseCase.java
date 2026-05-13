package com.bank.transactions.application.usecase.international;

import com.seubanco.transactions.domain.model.international.ExchangeQuote;
import com.seubanco.transactions.application.service.InternationalTransferService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;

// Use case responsável por consultar cotação de câmbio
@ApplicationScoped
public class QuoteExchangeRateUseCase {

    @Inject
    InternationalTransferService internationalTransferService;

    // Busca cotação atual da moeda desejada
    public ExchangeQuote execute(String sourceCurrency,
                                 String targetCurrency,
                                 BigDecimal amount) {

        return internationalTransferService.quoteExchangeRate(
                sourceCurrency,
                targetCurrency,
                amount
        );
    }
}
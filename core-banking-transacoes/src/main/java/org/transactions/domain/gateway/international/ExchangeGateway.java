package com.bank.transactions.domain.gateway.international;

import com.bank.transactions.domain.model.international.ExchangeQuote;
import com.bank.transactions.domain.model.international.ExchangeRate;

// Gateway responsável pelas integrações cambiais
public interface ExchangeGateway {

    // Consulta cotação de moedas
    ExchangeQuote quote(
            String sourceCurrency,
            String targetCurrency
    );

    // Obtém taxa cambial atual
    ExchangeRate getCurrentRate(
            String sourceCurrency,
            String targetCurrency
    );
}
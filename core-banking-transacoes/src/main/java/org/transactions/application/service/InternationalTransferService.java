package com.bank.transactions.application.service;

import com.bank.transactions.application.dto.request.international.ExecuteInternationalTransferRequest;
import com.bank.transactions.application.dto.response.international.InternationalTransferResponse;
import com.bank.transactions.domain.model.international.ExchangeQuote;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;

// Serviço responsável por remessas internacionais
@ApplicationScoped
public class InternationalTransferService {

    // Executa transferência internacional
    public InternationalTransferResponse executeTransfer(
            ExecuteInternationalTransferRequest request
    ) {
        return new InternationalTransferResponse();
    }

    // Consulta cotação cambial
    public ExchangeQuote quoteExchangeRate(
            String sourceCurrency,
            String targetCurrency,
            BigDecimal amount
    ) {
        return new ExchangeQuote();
    }

    // Confirma contrato de câmbio
    public void confirmExchangeContract(String exchangeContractId) {

    }
}
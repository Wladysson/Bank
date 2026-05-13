package com.bank.transactions.application.service;

import com.bank.transactions.application.dto.request.bank.ExecuteDocTransferRequest;
import com.bank.transactions.application.dto.request.bank.ExecuteTedTransferRequest;
import com.bank.transactions.application.dto.response.bank.DocTransferResponse;
import com.bank.transactions.application.dto.response.bank.TedTransferResponse;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;

// Serviço responsável pelas transferências bancárias
@ApplicationScoped
public class BankTransferService {

    // Executa transferência TED
    public TedTransferResponse executeTedTransfer(ExecuteTedTransferRequest request) {
        return new TedTransferResponse();
    }

    // Executa transferência DOC
    public DocTransferResponse executeDocTransfer(ExecuteDocTransferRequest request) {
        return new DocTransferResponse();
    }

    // Valida horário operacional bancário
    public boolean validateTransferWindow(LocalDateTime requestedAt) {
        return true;
    }
}
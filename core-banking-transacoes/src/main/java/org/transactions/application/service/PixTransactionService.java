package com.bank.transactions.application.service;

import com.bank.transactions.application.dto.request.pix.ExecutePixTransferRequest;
import com.bank.transactions.application.dto.request.pix.GeneratePixQrCodeRequest;
import com.bank.transactions.application.dto.request.pix.RefundPixTransactionRequest;
import com.bank.transactions.application.dto.response.pix.PixQrCodeResponse;
import com.bank.transactions.application.dto.response.pix.PixTransactionResponse;
import jakarta.enterprise.context.ApplicationScoped;

// Serviço responsável pelas operações PIX
@ApplicationScoped
public class PixTransactionService {

    // Executa transferência PIX
    public PixTransactionResponse executeTransfer(ExecutePixTransferRequest request) {
        return new PixTransactionResponse();
    }

    // Gera QR Code PIX
    public PixQrCodeResponse generateQrCode(GeneratePixQrCodeRequest request) {
        return new PixQrCodeResponse();
    }

    // Confirma liquidação da transação
    public void confirmSettlement(String transactionId) {

    }

    // Realiza devolução da transação PIX
    public PixTransactionResponse refundTransaction(RefundPixTransactionRequest request) {
        return new PixTransactionResponse();
    }

    // Consulta status da transação
    public PixTransactionResponse getTransactionStatus(String transactionId) {
        return new PixTransactionResponse();
    }
}
package com.bank.transactions.application.usecase.pix;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.UUID;

@ApplicationScoped
public class GetPixTransactionStatusUseCase {

    private final PixTransactionRepository pixTransactionRepository;

    @Inject
    public GetPixTransactionStatusUseCase(PixTransactionRepository pixTransactionRepository) {
        this.pixTransactionRepository = pixTransactionRepository;
    }

    public PixTransactionResponse execute(String transactionId) {

        UUID id = parse(transactionId);

        // 🔍 Busca da transação (não é mais "payment")
        PixTransaction transaction = pixTransactionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transação PIX não encontrada."));

        return PixTransactionResponse.from(transaction);
    }

    private UUID parse(String transactionId) {
        try {
            return UUID.fromString(transactionId);
        } catch (Exception e) {
            throw new IllegalArgumentException("ID da transação inválido.");
        }
    }
}
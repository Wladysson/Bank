package com.bank.transactions.application.usecase.pix;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.UUID;

@ApplicationScoped
public class ConfirmPixSettlementUseCase {

    private final PixTransactionRepository pixTransactionRepository;
    private final Event<PixTransactionCompletedEvent> eventPublisher;

    @Inject
    public ConfirmPixSettlementUseCase(
            PixTransactionRepository pixTransactionRepository,
            Event<PixTransactionCompletedEvent> eventPublisher) {
        this.pixTransactionRepository = pixTransactionRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public PixTransactionResponse execute(String transactionId) {

        UUID id = parse(transactionId);

        // 🔍 Busca da transação
        PixTransaction transaction = pixTransactionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transação Pix não encontrada."));

        // 🔒 Regra de consistência
        if (!transaction.isProcessing()) {
            throw new IllegalStateException("A transação não está em estado válido para liquidação.");
        }

        // 💰 Liquidação (dinheiro efetivamente confirmado)
        transaction.markAsCompleted();

        pixTransactionRepository.update(transaction);

        // 📡 Evento de liquidação
        eventPublisher.fire(
                new PixTransactionCompletedEvent(
                        transaction.getId(),
                        transaction.getEndToEndId(),
                        transaction.getAmount().toString(),
                        transaction.getCompletedAt()
                )
        );

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

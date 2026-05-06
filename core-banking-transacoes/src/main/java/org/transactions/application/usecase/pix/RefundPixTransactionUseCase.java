package com.bank.transactions.application.usecase.pix;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class RefundPixTransactionUseCase {

    private final PixTransactionRepository pixTransactionRepository;
    private final Event<PixTransactionRefundedEvent> eventPublisher;

    @Inject
    public RefundPixTransactionUseCase(
            PixTransactionRepository pixTransactionRepository,
            Event<PixTransactionRefundedEvent> eventPublisher) {
        this.pixTransactionRepository = pixTransactionRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public PixTransactionResponse execute(PixRefundRequest request) {

        validate(request);

        // 🔍 Busca da transação original
        PixTransaction originalTransaction = pixTransactionRepository
                .findById(request.transactionId())
                .orElseThrow(() -> new IllegalArgumentException("Transação original não encontrada."));

        // 🔒 Só pode estornar se já foi liquidada
        if (!originalTransaction.isCompleted()) {
            throw new IllegalStateException("A transação ainda não foi liquidada e não pode ser estornada.");
        }

        // 💰 Cria nova transação de estorno (não altera a original!)
        PixTransaction refundTransaction = PixTransaction.refundOf(
                originalTransaction,
                request.reason()
        );

        refundTransaction.markAsProcessing();

        pixTransactionRepository.save(refundTransaction);

        // 📡 Evento de estorno
        eventPublisher.fire(
                new PixTransactionRefundedEvent(
                        refundTransaction.getId(),
                        originalTransaction.getId(),
                        refundTransaction.getAmount().toString(),
                        refundTransaction.getCreatedAt()
                )
        );

        return PixTransactionResponse.from(refundTransaction);
    }

    private void validate(PixRefundRequest request) {

        if (request == null) {
            throw new IllegalArgumentException("A solicitação de estorno não pode ser nula.");
        }

        if (request.transactionId() == null) {
            throw new IllegalArgumentException("É necessário informar a transação a ser estornada.");
        }

        if (request.reason() == null || request.reason().isBlank()) {
            throw new IllegalArgumentException("É necessário informar o motivo do estorno.");
        }
    }
}
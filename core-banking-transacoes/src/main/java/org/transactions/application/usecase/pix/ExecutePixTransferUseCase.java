package com.bank.transactions.application.usecase.pix;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ExecutePixTransferUseCase {

    private final PixTransactionRepository pixTransactionRepository;
    private final Event<PixTransactionCreatedEvent> eventPublisher;

    @Inject
    public ExecutePixTransferUseCase(
            PixTransactionRepository pixTransactionRepository,
            Event<PixTransactionCreatedEvent> eventPublisher) {
        this.pixTransactionRepository = pixTransactionRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public PixTransactionResponse execute(PixTransactionRequest request) {

        validate(request);

        // 🔑 Criação da chave PIX validada
        PixKey pixKey = new PixKey(
                request.pixKey(),
                PixKeyType.RANDOM // depois você pode detectar dinamicamente
        );

        // 💰 Criação da transação (não é mais "payment")
        PixTransaction transaction = new PixTransaction(
                request.payerAccountId().toString(),
                pixKey,
                request.amount(),
                request.description(),
                PixTransactionType.TRANSFER
        );

        // 🔄 Estado inicial da transação
        transaction.markAsProcessing();

        // 💾 Persistência
        pixTransactionRepository.save(transaction);

        // 📡 Evento de domínio (agora é transação, não pagamento)
        eventPublisher.fire(
                new PixTransactionCreatedEvent(
                        transaction.getId(),
                        transaction.getEndToEndId(),
                        transaction.getAmount().toString(),
                        transaction.getCreatedAt()
                )
        );

        return PixTransactionResponse.from(transaction);
    }

    private void validate(PixTransactionRequest request) {

        if (request == null) {
            throw new IllegalArgumentException("A solicitação de transação Pix não pode ser nula.");
        }

        if (request.amount() == null || request.amount().signum() <= 0) {
            throw new IllegalArgumentException("O valor da transação deve ser maior que zero.");
        }

        if (request.pixKey() == null || request.pixKey().isBlank()) {
            throw new IllegalArgumentException("É necessária uma chave PIX válida.");
        }

        if (request.payerAccountId() == null) {
            throw new IllegalArgumentException("É necessário o identificador da conta de origem.");
        }
    }
}
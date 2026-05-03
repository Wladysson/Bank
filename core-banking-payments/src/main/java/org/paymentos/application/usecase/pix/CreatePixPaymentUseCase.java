package com.bank.payments.application.usecase.pix;

import com.bank.payments.application.dto.request.PixPaymentRequest;
import com.bank.payments.application.dto.response.PixPaymentResponse;
import com.bank.payments.domain.event.PixPaymentCreatedEvent;
import com.bank.payments.domain.model.PixKey;
import com.bank.payments.domain.model.PixKeyType;
import com.bank.payments.domain.model.PixPayment;
import com.bank.payments.domain.model.PixTransactionType;
import com.bank.payments.domain.repository.PixRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CreatePixPaymentUseCase {

    private final PixRepository pixRepository;
    private final Event<PixPaymentCreatedEvent> eventPublisher;

    @Inject
    public CreatePixPaymentUseCase(
            PixRepository pixRepository,
            Event<PixPaymentCreatedEvent> eventPublisher) {
        this.pixRepository = pixRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public PixPaymentResponse execute(PixPaymentRequest request) {

        validate(request);

        PixKey validatedKey = new PixKey(
                request.pixKey(),
                PixKeyType.RANDOM
        );

        PixPayment pixPayment = new PixPayment(
                request.payerAccountId().toString(),
                validatedKey,
                request.amount(),
                request.description(),
                PixTransactionType.PAYMENT
        );

        pixPayment.markAsProcessing();

        pixRepository.save(pixPayment);

        eventPublisher.fire(
                new PixPaymentCreatedEvent(
                        pixPayment.getId(),
                        pixPayment.getEndToEndId(),
                        pixPayment.getAmount().toString(),
                        pixPayment.getCreatedAt()
                )
        );

        return PixPaymentResponse.from(pixPayment);
    }

    private void validate(PixPaymentRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("A solicitação de pagamento Pix não pode ser nula.");
        }

        if (request.amount() == null || request.amount().signum() <= 0) {
            throw new IllegalArgumentException("O valor do pagamento Pix deve ser maior que zero.");
        }

        if (request.pixKey() == null || request.pixKey().isBlank()) {
            throw new IllegalArgumentException("É necessária uma chave PIX.");
        }

        if (request.payerAccountId() == null) {
            throw new IllegalArgumentException("É necessário o identificador do pagador.");
        }
    }
}
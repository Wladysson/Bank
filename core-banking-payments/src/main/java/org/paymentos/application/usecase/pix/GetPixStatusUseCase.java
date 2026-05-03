package com.bank.payments.application.usecase.pix;

import com.bank.payments.application.dto.response.PixPaymentResponse;
import com.bank.payments.domain.model.PixPayment;
import com.bank.payments.domain.repository.PixRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class GetPixStatusUseCase {

    private final PixRepository pixRepository;

    @Inject
    public GetPixStatusUseCase(PixRepository pixRepository) {
        this.pixRepository = pixRepository;
    }

    public PixPaymentResponse execute(String transactionId) {

        PixPayment payment = pixRepository.findByTxId(transactionId)
                .orElseThrow(() -> new IllegalArgumentException("Pagamento PIX não encontrado"));

        return PixPaymentResponse.from(payment);
    }
}
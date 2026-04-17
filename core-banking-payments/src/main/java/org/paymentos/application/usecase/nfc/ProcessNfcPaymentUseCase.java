package com.bank.payments.application.usecase.nfc;

import com.bank.payments.application.dto.request.PaymentRequest;
import com.bank.payments.application.dto.response.PaymentResponse;
import com.bank.payments.application.service.PaymentOrchestratorService;
import com.bank.payments.application.usecase.payment.ProcessPaymentCommand;
import com.bank.payments.domain.model.PaymentMethod;
import com.bank.payments.domain.model.PaymentType;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProcessNfcPaymentUseCase {

    @Inject
    PaymentOrchestratorService orchestratorService;

    @Transactional
    public PaymentResponse execute(PaymentRequest request) {

        ProcessPaymentCommand command = new ProcessPaymentCommand();
        command.setPayerId(request.getPayerId());
        command.setPayeeId(request.getPayeeId());
        command.setAmount(request.getAmount());
        command.setCurrency(request.getCurrency());
        command.setMethod(PaymentMethod.NFC);
        command.setType(PaymentType.POS);
        command.setDescription("Pagamento por aproximação (NFC)");
        command.setExternalReference(request.getExternalReference());

        return orchestratorService.processPayment(command);
    }
}
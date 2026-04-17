package com.bank.payments.application.usecase.boleto;

import com.bank.payments.application.dto.request.BoletoPaymentRequest;
import com.bank.payments.application.dto.response.PaymentResponse;
import com.bank.payments.application.service.PaymentOrchestratorService;
import com.bank.payments.application.usecase.payment.ProcessPaymentCommand;
import com.bank.payments.domain.model.PaymentMethod;
import com.bank.payments.domain.model.PaymentType;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProcessBoletoPaymentUseCase {

    @Inject
    ValidateBoletoUseCase validateBoletoUseCase;

    @Inject
    ParseLinhaDigitavelUseCase parseLinhaDigitavelUseCase;

    @Inject
    PaymentOrchestratorService orchestratorService;

    @Transactional
    public PaymentResponse execute(BoletoPaymentRequest request) {

        // 1. Validar boleto
        validateBoletoUseCase.execute(request);

        // 2. Parse linha digitável
        var boletoData = parseLinhaDigitavelUseCase.execute(request.getLinhaDigitavel());

        // 3. Montar comando padrão
        ProcessPaymentCommand command = new ProcessPaymentCommand();
        command.setPayerId(request.getPayerId());
        command.setPayeeId(boletoData.getBeneficiary());
        command.setAmount(boletoData.getAmount());
        command.setCurrency("BRL");
        command.setMethod(PaymentMethod.BOLETO);
        command.setType(PaymentType.BILL_PAYMENT);
        command.setDescription("Pagamento de boleto");
        command.setExternalReference(request.getLinhaDigitavel());

        // 4. Fluxo principal
        return orchestratorService.processPayment(command);
    }
}
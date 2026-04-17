package com.bank.payments.application.usecase.batch;

import com.bank.payments.application.dto.request.BatchPaymentRequest;
import com.bank.payments.application.dto.response.BatchResponse;
import com.bank.payments.application.dto.response.PaymentResponse;
import com.bank.payments.application.service.PaymentOrchestratorService;
import com.bank.payments.application.usecase.payment.ProcessPaymentCommand;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProcessBatchPaymentsUseCase {

    @Inject
    ValidateBatchUseCase validateBatchUseCase;

    @Inject
    PaymentOrchestratorService orchestratorService;

    @Transactional
    public BatchResponse execute(BatchPaymentRequest request) {

        // 1. validar lote
        validateBatchUseCase.execute(request);

        List<PaymentResponse> success = new ArrayList<>();
        List<String> failed = new ArrayList<>();

        // 2. iterar pagamentos
        request.getPayments().forEach(item -> {
            try {
                ProcessPaymentCommand command = new ProcessPaymentCommand();
                command.setPayerId(item.getPayerId());
                command.setPayeeId(item.getPayeeId());
                command.setAmount(item.getAmount());
                command.setCurrency(item.getCurrency());
                command.setMethod(item.getMethod());
                command.setType(item.getType());
                command.setDescription(item.getDescription());
                command.setExternalReference(item.getExternalReference());

                PaymentResponse response = orchestratorService.processPayment(command);
                success.add(response);

            } catch (Exception e) {
                failed.add(item.getExternalReference());
            }
        });

        // 3. retorno consolidado
        return new BatchResponse(success, failed);
    }
}
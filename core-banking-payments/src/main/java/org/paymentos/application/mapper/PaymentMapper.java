package com.bank.payments.application.mapper;

import com.bank.payments.application.dto.internal.LedgerPostingRequest;
import com.bank.payments.application.dto.request.PaymentRequest;
import com.bank.payments.application.dto.response.PaymentResponse;
import com.bank.payments.application.usecase.payment.ProcessPaymentCommand;
import com.bank.payments.domain.model.Payment;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaymentMapper {

    public ProcessPaymentCommand toCommand(PaymentRequest request) {
        ProcessPaymentCommand command = new ProcessPaymentCommand();
        command.setPayerId(request.getPayerId());
        command.setPayeeId(request.getPayeeId());
        command.setAmount(request.getAmount());
        command.setCurrency(request.getCurrency());
        command.setMethod(request.getMethod());
        command.setType(request.getType());
        command.setDescription(request.getDescription());
        command.setExternalReference(request.getExternalReference());
        return command;
    }

    public PaymentResponse toResponse(Payment payment) {
        return PaymentResponse.from(payment);
    }

    public LedgerPostingRequest toLedger(Payment payment) {
        return new LedgerPostingRequest(
                payment.getId(),
                payment.getPayerId(),   // débito
                payment.getPayeeId(),   // crédito
                payment.getAmount(),
                payment.getCurrency(),
                payment.getDescription()
        );
    }
}
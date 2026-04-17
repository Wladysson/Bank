package com.bank.payments.application.mapper;

import com.bank.payments.application.dto.request.BoletoPaymentRequest;
import com.bank.payments.application.usecase.boleto.ParseLinhaDigitavelUseCase.BoletoData;
import com.bank.payments.application.usecase.payment.ProcessPaymentCommand;
import com.bank.payments.domain.model.PaymentMethod;
import com.bank.payments.domain.model.PaymentType;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BoletoMapper {

    public ProcessPaymentCommand toCommand(BoletoPaymentRequest request, BoletoData data) {

        ProcessPaymentCommand command = new ProcessPaymentCommand();
        command.setPayerId(request.getPayerId());
        command.setPayeeId(data.getBeneficiary());
        command.setAmount(data.getAmount());
        command.setCurrency("BRL");
        command.setMethod(PaymentMethod.BOLETO);
        command.setType(PaymentType.BILL_PAYMENT);
        command.setDescription("Pagamento de boleto");
        command.setExternalReference(request.getLinhaDigitavel());

        return command;
    }
}
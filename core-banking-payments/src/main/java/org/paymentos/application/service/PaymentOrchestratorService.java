package com.bank.payments.application.service;

import com.bank.payments.application.dto.request.RefundRequest;
import com.bank.payments.application.dto.response.PaymentResponse;
import com.bank.payments.application.dto.response.PaymentStatusResponse;
import com.bank.payments.application.usecase.payment.ProcessPaymentCommand;
import com.bank.payments.domain.model.Payment;
import com.bank.payments.domain.model.PaymentStatus;
import com.bank.payments.domain.repository.PaymentRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PaymentOrchestratorService {

    @Inject
    PaymentRepository paymentRepository;

    @Inject
    PaymentStateMachine stateMachine;

    @Inject
    FraudCheckService fraudCheckService;

    @Inject
    LimitCheckService limitCheckService;

    @Inject
    FeeService feeService;

    @Inject
    PaymentRoutingService routingService;

    @Inject
    NotificationService notificationService;

    @Inject
    AuditService auditService;

    // fluxo principal
    public PaymentResponse processPayment(ProcessPaymentCommand command) {

        // 1. Criar entidade
        Payment payment = Payment.create(command);

        // 2. Validar estado inicial
        stateMachine.validateInitial(payment);

        // 3. Antifraude
        fraudCheckService.check(payment);

        // 4. Limite
        limitCheckService.check(payment);

        // 5. Calcular taxas
        feeService.applyFees(payment);

        // 6. Enviar para gateway
        routingService.route(payment);

        // 7. Atualizar status
        payment.markAsProcessed();

        // 8. Persistir
        paymentRepository.save(payment);

        // 9. Notificar
        notificationService.notifySuccess(payment);

        // 10. Auditoria
        auditService.log("PAYMENT_PROCESSED", payment.getId());

        return PaymentResponse.from(payment);
    }

    // Refund
    public PaymentResponse refundPayment(RefundRequest request) {
        Payment payment = paymentRepository.findById(request.getPaymentId())
                .orElseThrow(() -> new RuntimeException(
                        "Payment não encontrado: " + request.getPaymentId()
                ));

        payment.markAsRefunded();

        paymentRepository.save(payment);

        notificationService.notifyRefund(payment);

        return PaymentResponse.from(payment);
    }

    // Chargeback
    public void processChargeback(String paymentId, String reason) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Payment não encontrado: " + paymentId
                ));

        payment.markAsChargeback();

        paymentRepository.save(payment);

        auditService.log("CHARGEBACK", paymentId);
    }

    // Status
    public PaymentStatusResponse getPaymentStatus(String paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Payment não encontrado: " + paymentId
                ));

        return new PaymentStatusResponse(payment.getId(), payment.getStatus());
    }

    //Validação isolada
    public void validatePayment(ProcessPaymentCommand command) {
        if (command.getAmount() == null || command.getAmount().doubleValue() <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
    }
}
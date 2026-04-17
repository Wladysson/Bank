package com.bank.payments.application.usecase.recurring;

import com.bank.payments.application.service.PaymentOrchestratorService;
import com.bank.payments.application.usecase.payment.ProcessPaymentCommand;
import com.bank.payments.domain.model.PaymentMethod;
import com.bank.payments.domain.model.PaymentType;
import com.bank.payments.domain.model.Subscription;
import com.bank.payments.domain.repository.SubscriptionRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class ExecuteRecurringPaymentUseCase {

    @Inject
    SubscriptionRepository subscriptionRepository;

    @Inject
    PaymentOrchestratorService orchestratorService;

    @Transactional
    public void execute() {

        List<Subscription> subscriptions = subscriptionRepository.findActiveDueSubscriptions(LocalDate.now());

        for (Subscription sub : subscriptions) {
            try {
                ProcessPaymentCommand command = new ProcessPaymentCommand();
                command.setPayerId(sub.getUserId());
                command.setPayeeId(sub.getMerchantId());
                command.setAmount(sub.getAmount());
                command.setCurrency(sub.getCurrency());
                command.setMethod(PaymentMethod.CARD); // ou outro
                command.setType(PaymentType.RECURRING);
                command.setDescription("Pagamento recorrente");
                command.setExternalReference("SUB_" + sub.getId());

                orchestratorService.processPayment(command);

                sub.updateNextExecutionDate();

            } catch (Exception e) {
                sub.incrementFailureCount();
            }
        }
    }
}
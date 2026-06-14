package com.bank.account.domain.service;

import com.bank.account.domain.model.CustomerId;
import com.bank.account.domain.model.AccountType;

 //Policy responsável por validar elegibilidade de abertura e manutenção de contas
 //Regras podem depender de customer, tipo de conta e contexto regulatório

public final class AccountEligibilityPolicy {

     //Verifica se o cliente pode abrir uma conta do tipo especificado

    public boolean isEligible(CustomerId customerId, AccountType accountType) {
        if (customerId == null || accountType == null) { // valida entrada básica
            return false;
        }

        // regra base: todos clientes podem abrir conta simples
        // regras futuras: KYC, risco, restrições legais
        return switch (accountType) {
            case CHECKING, SAVINGS, SALARY, DIGITAL -> true;
            case INVESTMENT -> validateInvestmentEligibility(customerId);
            case JOINT -> true; // validação adicional feita em JointAccountValidationService
            case CORPORATE, STUDENT, ESCROW, PREPAID -> true; // tipos adicionais habilitados
        };
    }

     //Regra específica para contas de investimento
    private boolean validateInvestmentEligibility(CustomerId customerId) {
        return true; // placeholder para integração com risk/kyc service
    }
}
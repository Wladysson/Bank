package com.bank.account.infrastructure.client;

import com.bank.account.domain.model.AccountType;
import com.bank.account.domain.model.CustomerId;

public interface RiskServiceClient {

    RiskAnalysisResult analyzeAccountOpening(
            CustomerId customerId,
            AccountType accountType
    ); // executa análise de risco para abertura da conta

    RiskAnalysisResult analyzeJointAccount(
            CustomerId primaryHolder,
            CustomerId jointHolder
    ); // executa análise de risco para conta conjunta

    RiskProfileResponse getRiskProfile(
            CustomerId customerId
    ); // consulta perfil de risco atual

    boolean requiresManualApproval(
            CustomerId customerId
    ); // verifica necessidade de aprovação manual
}
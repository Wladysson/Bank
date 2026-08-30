package com.bank.account.limit.domain.model;

public enum LimitType {

    PIX_TRANSFER, // limite para transferências via Pix

    TED_TRANSFER, // limite para transferências via TED

    ATM_WITHDRAWAL, // limite para saques em caixas eletrônicos

    CARD_PURCHASE, // limite para compras realizadas com cartão

    BILL_PAYMENT, // limite para pagamentos de boletos

    ACCOUNT_TRANSFER, // limite para transferências entre contas

    INTERNATIONAL_TRANSFER, // limite para transferências internacionais

    INVESTMENT, // limite para operações de investimento

    LOAN_OPERATION, // limite relacionado a operações de crédito

    DAILY_TRANSACTION, // limite geral diário de movimentações

    MONTHLY_TRANSACTION, // limite geral mensal de movimentações

    OTHER // tipo de limite genérico
}
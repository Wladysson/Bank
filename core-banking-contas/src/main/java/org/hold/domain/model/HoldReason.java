package com.bank.account.hold.domain.model;

public enum HoldReason {

    PIX_TRANSFER, // reserva para liquidação de pix

    TED_TRANSFER, // reserva para transferência ted

    DOC_TRANSFER, // reserva para transferência doc

    CARD_AUTHORIZATION, // autorização de compra em cartão

    BILL_PAYMENT, // pagamento de boleto

    INVESTMENT_APPLICATION, // aplicação financeira pendente

    LOAN_INSTALLMENT, // cobrança de parcela de crédito

    JUDICIAL_BLOCK, // bloqueio judicial de valores

    FRAUD_ANALYSIS, // retenção para análise antifraude

    COMPLIANCE_REVIEW, // retenção para análise regulatória

    DISPUTE_PROCESSING, // contestação em processamento

    INTERNAL_SETTLEMENT, // liquidação interna entre contas

    MANUAL_OPERATION, // reserva operacional realizada manualmente

    OTHER // motivo genérico
}
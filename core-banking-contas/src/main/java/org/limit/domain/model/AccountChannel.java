package com.bank.account.limit.domain.model;

public enum AccountChannel {

    MOBILE_APP, // aplicativo móvel

    INTERNET_BANKING, // internet banking

    ATM, // caixa eletrônico

    BRANCH, // agência física

    POS, // terminal de pagamento

    OPEN_FINANCE, // integrações Open Finance

    API, // APIs externas autorizadas

    CALL_CENTER, // atendimento telefônico

    SELF_SERVICE, // autoatendimento

    INTERNAL_SYSTEM, // sistemas internos do banco

    PIX, // operações iniciadas via Pix

    OTHER // canal genérico
}
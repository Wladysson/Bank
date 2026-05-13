package com.bank.transactions.domain.model.pix;

// Enum responsável pelos tipos de operação PIX
public enum PixTransactionType {

    TRANSFER,
    QR_CODE_PAYMENT,
    REFUND,
    CASH_OUT,
    CASH_IN
}
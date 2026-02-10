package com.bank.account.domain.model;

public enum AccountType {
    CHECKING,        // Conta corrente (uso diário)
    SAVINGS,         // Poupança
    CORPORATE,       // Conta empresarial

    INVESTMENT,      // Conta de investimento
    SALARY,          // Conta salário
    JOINT,           // Conta conjunta (multi-titular)

    STUDENT,         // Conta universitária/jovem
    DIGITAL,         // Conta digital (sem agência física)

    ESCROW,          // Conta de garantia (dinheiro bloqueado até condição)
    PREPAID          // Conta pré-paga (saldo carregado antecipadamente
}
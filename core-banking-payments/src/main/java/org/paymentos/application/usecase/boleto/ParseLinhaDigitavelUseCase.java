package com.bank.payments.application.usecase.boleto;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;

@ApplicationScoped
public class ParseLinhaDigitavelUseCase {

    public BoletoData execute(String linhaDigitavel) {

        // SIMPLIFICADO (mock)
        // Normalmente você extrai:
        // - banco
        // - valor
        // - vencimento
        // - beneficiário

        BoletoData data = new BoletoData();
        data.setAmount(new BigDecimal("100.00")); // mock
        data.setBeneficiary("BENEFICIARIO_EXEMPLO");

        return data;
    }

    public static class BoletoData {
        private BigDecimal amount;
        private String beneficiary;

        public BigDecimal getAmount() { return amount; }
        public String getBeneficiary() { return beneficiary; }

        public void setAmount(BigDecimal amount) { this.amount = amount; }
        public void setBeneficiary(String beneficiary) { this.beneficiary = beneficiary; }
    }
}
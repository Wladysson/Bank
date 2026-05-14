package com.bank.transactions.domain.model.international;

import com.bank.transactions.domain.model.common.Money;
import com.bank.transactions.domain.model.common.Transaction;

import java.time.LocalDateTime;

// Entidade responsável pelas transferências internacionais
public class InternationalTransfer extends Transaction {

    // Conta remetente
    private String sourceAccountId;

    // Nome do beneficiário internacional
    private String beneficiaryName;

    // País de destino
    private String destinationCountry;

    // Banco destinatário
    private String destinationBank;

    // Código SWIFT da instituição
    private String swiftCode;

    // Valor original da transferência
    private Money sourceAmount;

    // Valor convertido
    private Money convertedAmount;

    // Cotação utilizada
    private ExchangeRate exchangeRate;

    // Finalidade da remessa
    private RemittancePurpose remittancePurpose;

    // Horário de liquidação internacional
    private LocalDateTime settledAt;

    // Marca operação como liquidada
    public void settle() {
        this.settledAt = LocalDateTime.now();
    }

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(String sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getDestinationBank() {
        return destinationBank;
    }

    public void setDestinationBank(String destinationBank) {
        this.destinationBank = destinationBank;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public Money getSourceAmount() {
        return sourceAmount;
    }

    public void setSourceAmount(Money sourceAmount) {
        this.sourceAmount = sourceAmount;
    }

    public Money getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(Money convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public ExchangeRate getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(ExchangeRate exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public RemittancePurpose getRemittancePurpose() {
        return remittancePurpose;
    }

    public void setRemittancePurpose(RemittancePurpose remittancePurpose) {
        this.remittancePurpose = remittancePurpose;
    }

    public LocalDateTime getSettledAt() {
        return settledAt;
    }
}
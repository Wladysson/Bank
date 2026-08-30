package com.bank.account.overdraft.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

public class OverdraftLimit {

    private final BigDecimal amount; // valor máximo disponibilizado para o cheque especial
    private BigDecimal usedAmount; // valor atualmente utilizado

    public OverdraftLimit(
            BigDecimal amount
    ) {
        if (amount == null || amount.signum() < 0) {
            throw new IllegalArgumentException(
                    "Overdraft limit amount cannot be negative"
            ); // impede limite inválido
        }

        this.amount = amount;
        this.usedAmount = BigDecimal.ZERO; // inicia sem utilização
    }

    public void use(
            BigDecimal amount
    ) {

        validateAmount(amount); // valida o valor solicitado

        if (getAvailableAmount().compareTo(amount) < 0) {
            throw new IllegalStateException(
                    "Overdraft limit exceeded"
            ); // impede utilização acima do limite
        }

        this.usedAmount = this.usedAmount.add(amount); // registra utilização
    }

    public void release(
            BigDecimal amount
    ) {

        validateAmount(amount); // valida o valor a liberar

        if (usedAmount.compareTo(amount) < 0) {
            throw new IllegalStateException(
                    "Released amount exceeds overdraft usage"
            ); // impede liberação superior ao utilizado
        }

        this.usedAmount = this.usedAmount.subtract(amount); // reduz utilização
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getUsedAmount() {
        return usedAmount;
    }

    public BigDecimal getAvailableAmount() {
        return amount.subtract(usedAmount); // calcula limite disponível
    }

    public boolean hasAvailableLimit() {
        return getAvailableAmount().signum() > 0; // verifica disponibilidade
    }

    public boolean isFullyUsed() {
        return getAvailableAmount().signum() == 0; // verifica utilização integral
    }

    private void validateAmount(
            BigDecimal amount
    ) {

        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException(
                    "Amount must be greater than zero"
            ); // garante valor positivo
        }
    }

    @Override
    public boolean equals(
            Object object
    ) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof OverdraftLimit other)) {
            return false;
        }

        return Objects.equals(
                amount,
                other.amount
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
package com.bank.account.overdraft.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class OverdraftContract {

    private final String contractId; // identificador do contrato
    private final String accountId; // conta vinculada ao cheque especial
    private final OverdraftLimit limit; // limite contratado
    private final BigDecimal interestRate; // taxa de juros aplicável
    private final LocalDateTime effectiveAt; // início da vigência
    private LocalDateTime expiresAt; // término da vigência
    private boolean active; // indica se o contrato está ativo

    public OverdraftContract(
            String contractId,
            String accountId,
            OverdraftLimit limit,
            BigDecimal interestRate,
            LocalDateTime effectiveAt,
            LocalDateTime expiresAt
    ) {

        validateContract(
                contractId,
                accountId,
                limit,
                interestRate,
                effectiveAt,
                expiresAt
        ); // valida os dados contratuais

        this.contractId = contractId;
        this.accountId = accountId;
        this.limit = limit;
        this.interestRate = interestRate;
        this.effectiveAt = effectiveAt;
        this.expiresAt = expiresAt;
        this.active = true; // contrato inicia ativo
    }

    public void activate() {

        this.active = true; // ativa o contrato
    }

    public void deactivate() {

        this.active = false; // desativa o contrato
    }

    public void extend(
            LocalDateTime newExpirationDate
    ) {

        if (!active) {
            throw new IllegalStateException(
                    "Inactive overdraft contract cannot be extended"
            ); // contrato inativo não pode ser prorrogado
        }

        if (newExpirationDate == null
                || !newExpirationDate.isAfter(effectiveAt)) {
            throw new IllegalArgumentException(
                    "Expiration date must be after effective date"
            ); // garante vigência válida
        }

        this.expiresAt = newExpirationDate; // atualiza término da vigência
    }

    public boolean isValidAt(
            LocalDateTime dateTime
    ) {

        if (!active || dateTime == null) {
            return false; // contrato não pode ser utilizado
        }

        boolean startsBefore =
                !dateTime.isBefore(effectiveAt);

        boolean endsAfter =
                expiresAt == null || !dateTime.isAfter(expiresAt);

        return startsBefore && endsAfter; // verifica vigência contratual
    }

    public boolean canUse(
            BigDecimal amount,
            LocalDateTime dateTime
    ) {

        if (!isValidAt(dateTime)) {
            return false; // contrato fora da vigência
        }

        if (amount == null || amount.signum() <= 0) {
            return false; // valor inválido
        }

        return limit.getAvailableAmount()
                .compareTo(amount) >= 0; // verifica capacidade disponível
    }

    public String getContractId() {
        return contractId;
    }

    public String getAccountId() {
        return accountId;
    }

    public OverdraftLimit getLimit() {
        return limit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public LocalDateTime getEffectiveAt() {
        return effectiveAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public boolean isActive() {
        return active;
    }

    private void validateContract(
            String contractId,
            String accountId,
            OverdraftLimit limit,
            BigDecimal interestRate,
            LocalDateTime effectiveAt,
            LocalDateTime expiresAt
    ) {

        if (contractId == null || contractId.isBlank()) {
            throw new IllegalArgumentException(
                    "Contract id cannot be blank"
            );
        }

        if (accountId == null || accountId.isBlank()) {
            throw new IllegalArgumentException(
                    "Account id cannot be blank"
            );
        }

        if (limit == null) {
            throw new IllegalArgumentException(
                    "Overdraft limit cannot be null"
            );
        }

        if (interestRate == null || interestRate.signum() < 0) {
            throw new IllegalArgumentException(
                    "Interest rate cannot be negative"
            );
        }

        if (effectiveAt == null) {
            throw new IllegalArgumentException(
                    "Effective date cannot be null"
            );
        }

        if (expiresAt != null
                && !expiresAt.isAfter(effectiveAt)) {
            throw new IllegalArgumentException(
                    "Expiration date must be after effective date"
            );
        }
    }

    @Override
    public boolean equals(
            Object object
    ) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof OverdraftContract other)) {
            return false;
        }

        return Objects.equals(
                contractId,
                other.contractId
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractId);
    }
}
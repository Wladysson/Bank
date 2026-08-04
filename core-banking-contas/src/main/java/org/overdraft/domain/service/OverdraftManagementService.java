package com.bank.account.overdraft.domain.service;

import com.bank.account.overdraft.domain.model.OverdraftContract;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OverdraftManagementService {

    public boolean canUse(
            OverdraftContract contract,
            BigDecimal amount,
            LocalDateTime operationDate
    ) {

        if (contract == null) {
            return false; // não existe contrato disponível
        }

        return contract.canUse(
                amount,
                operationDate
        ); // delega a validação ao agregado contratual
    }

    public void use(
            OverdraftContract contract,
            BigDecimal amount,
            LocalDateTime operationDate
    ) {

        if (!canUse(
                contract,
                amount,
                operationDate
        )) {
            throw new IllegalStateException(
                    "Overdraft cannot be used"
            ); // impede utilização inválida
        }

        contract.getLimit().use(
                amount
        ); // registra utilização do limite
    }

    public void release(
            OverdraftContract contract,
            BigDecimal amount
    ) {

        if (contract == null) {
            throw new IllegalArgumentException(
                    "Overdraft contract cannot be null"
            ); // contrato obrigatório
        }

        contract.getLimit().release(
                amount
        ); // devolve capacidade ao limite
    }

    public BigDecimal getAvailableAmount(
            OverdraftContract contract
    ) {

        if (contract == null) {
            return BigDecimal.ZERO; // contrato inexistente não possui disponibilidade
        }

        return contract.getLimit()
                .getAvailableAmount(); // retorna capacidade disponível
    }
}
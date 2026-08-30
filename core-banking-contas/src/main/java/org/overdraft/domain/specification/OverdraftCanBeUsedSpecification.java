package com.bank.account.overdraft.domain.specification;

import com.bank.account.overdraft.domain.model.OverdraftContract;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OverdraftCanBeUsedSpecification {

    public boolean isSatisfiedBy(
            OverdraftContract contract,
            BigDecimal amount,
            LocalDateTime operationDate
    ) {

        if (contract == null) {
            return false; // contrato obrigatório
        }

        if (amount == null || amount.signum() <= 0) {
            return false; // valor deve ser positivo
        }

        if (operationDate == null) {
            return false; // data da operação obrigatória
        }

        if (!contract.isActive()) {
            return false; // contrato inativo não pode ser utilizado
        }

        if (!contract.isValidAt(operationDate)) {
            return false; // contrato deve estar dentro da vigência
        }

        return contract.getLimit()
                .getAvailableAmount()
                .compareTo(amount) >= 0; // verifica disponibilidade do limite
    }
}
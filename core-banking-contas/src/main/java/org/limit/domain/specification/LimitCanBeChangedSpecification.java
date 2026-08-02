package com.bank.account.limit.domain.specification;

import com.bank.account.limit.domain.model.AccountLimit;

import java.math.BigDecimal;

public class LimitCanBeChangedSpecification {

    public boolean isSatisfiedBy(
            AccountLimit accountLimit,
            BigDecimal newAmount
    ) {

        if (accountLimit == null) {
            return false; // não existe limite válido para alteração
        }

        if (!accountLimit.isActive()) {
            return false; // limite inativo não pode ser alterado
        }

        if (newAmount == null) {
            return false; // novo valor deve ser informado
        }

        if (newAmount.signum() < 0) {
            return false; // não permite limite negativo
        }

        if (accountLimit.getConsumedAmount() != null
                && newAmount.compareTo(
                accountLimit.getConsumedAmount()
        ) < 0) {
            return false; // novo limite não pode ficar abaixo do valor já consumido
        }

        return true; // limite está elegível para alteração
    }
}
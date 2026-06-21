package com.bank.account.hold.domain.specification;

import com.bank.account.hold.domain.model.HoldBalance;
import com.bank.account.hold.domain.model.HoldStatus;

public class HoldCanBeReleasedSpecification {

    public boolean isSatisfiedBy(
            HoldBalance hold
    ) {

        if (hold == null) {
            return false; // não existe hold para validar
        }

        if (hold.getStatus() != HoldStatus.ACTIVE) {
            return false; // somente holds ativos podem ser liberados
        }

        if (hold.getAmount() == null || hold.getAmount().doubleValue() <= 0) {
            return false; // não permite liberação de valores inválidos
        }

        return true; // hold está elegível para liberação
    }
}
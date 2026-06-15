package com.bank.account.hold.domain.specification;

import com.bank.account.domain.model.HoldBalance;

public class HoldCanBeReleasedSpecification {

    public boolean isSatisfiedBy(
            HoldBalance hold
    ) {

        if (hold == null) {
            return false;
        }

        if (!hold.isActive()) {
            return false;
        }

        if (hold.getAmount() == null ||
                hold.getAmount().doubleValue() <= 0) {
            return false;
        }

        return true;
    }
}
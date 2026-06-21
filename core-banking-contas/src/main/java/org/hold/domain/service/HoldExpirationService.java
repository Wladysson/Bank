package com.bank.account.hold.domain.service;

import com.bank.account.domain.model.HoldBalance;

public class HoldExpirationService {

    public boolean isExpired(
            HoldBalance hold
    ) {

        if (hold == null) {
            return false;
        }

        // modelo atual não possui data de expiração
        return false;
    }

    public boolean canExpire(
            HoldBalance hold
    ) {

        return hold != null
                && hold.isActive();
    }

    public void expire(
            HoldBalance hold
    ) {

        if (!canExpire(hold)) {
            return;
        }

        hold.release(); // libera o hold
    }

    public long getRemainingMinutes(
            HoldBalance hold
    ) {

        // modelo atual não possui expiração
        return 0L;
    }
}
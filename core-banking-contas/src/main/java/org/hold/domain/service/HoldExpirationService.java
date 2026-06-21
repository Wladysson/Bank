package com.bank.account.hold.domain.service;

import com.bank.account.hold.domain.model.HoldBalance;
import com.bank.account.hold.domain.model.HoldStatus;

import java.time.LocalDateTime;

public class HoldExpirationService {

    public boolean isExpired(
            HoldBalance hold
    ) {

        if (hold == null) {
            return false;
        }

        if (hold.getExpirationDate() == null) {
            return false; // reservas sem expiração permanecem válidas
        }

        return LocalDateTime.now()
                .isAfter(hold.getExpirationDate()); // verifica se a reserva expirou
    }

    public boolean canExpire(
            HoldBalance hold
    ) {

        return hold != null
                && hold.getStatus() == HoldStatus.ACTIVE
                && isExpired(hold); // somente reservas ativas podem expirar
    }

    public void expire(
            HoldBalance hold
    ) {

        if (!canExpire(hold)) {
            return;
        }

        hold.setStatus(HoldStatus.EXPIRED); // marca a reserva como expirada
    }

    public long getRemainingMinutes(
            HoldBalance hold
    ) {

        if (hold == null || hold.getExpirationDate() == null) {
            return 0L;
        }

        return java.time.Duration.between(
                LocalDateTime.now(),
                hold.getExpirationDate()
        ).toMinutes(); // calcula minutos restantes para expiração
    }
}
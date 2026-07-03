package com.bank.account.hold.infrastructure.observability;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

public class HoldMetrics {

    private final AtomicLong holdsCreated = new AtomicLong(); // quantidade de reservas criadas

    private final AtomicLong holdsReleased = new AtomicLong(); // quantidade de reservas liberadas

    private final AtomicLong holdsExpired = new AtomicLong(); // quantidade de reservas expiradas

    private final AtomicLong holdsCancelled = new AtomicLong(); // quantidade de reservas canceladas

    private final AtomicLong holdsExtended = new AtomicLong(); // quantidade de reservas prorrogadas

    private BigDecimal reservedAmount = BigDecimal.ZERO; // valor total atualmente reservado

    private BigDecimal releasedAmount = BigDecimal.ZERO; // valor total liberado

    public void registerCreated(
            BigDecimal amount
    ) {

        holdsCreated.incrementAndGet(); // incrementa quantidade de reservas criadas

        reservedAmount = reservedAmount.add(amount); // acumula valor reservado
    }

    public void registerReleased(
            BigDecimal amount
    ) {

        holdsReleased.incrementAndGet(); // incrementa quantidade de reservas liberadas

        releasedAmount = releasedAmount.add(amount); // acumula valor liberado

        reservedAmount = reservedAmount.subtract(amount); // reduz valor reservado
    }

    public void registerExpired(
            BigDecimal amount
    ) {

        holdsExpired.incrementAndGet(); // incrementa quantidade de reservas expiradas

        reservedAmount = reservedAmount.subtract(amount); // reduz valor reservado
    }

    public void registerCancelled(
            BigDecimal amount
    ) {

        holdsCancelled.incrementAndGet(); // incrementa quantidade de reservas canceladas

        reservedAmount = reservedAmount.subtract(amount); // reduz valor reservado
    }

    public void registerExtended() {

        holdsExtended.incrementAndGet(); // incrementa quantidade de prorrogações
    }

    public long getHoldsCreated() {
        return holdsCreated.get();
    }

    public long getHoldsReleased() {
        return holdsReleased.get();
    }

    public long getHoldsExpired() {
        return holdsExpired.get();
    }

    public long getHoldsCancelled() {
        return holdsCancelled.get();
    }

    public long getHoldsExtended() {
        return holdsExtended.get();
    }

    public BigDecimal getReservedAmount() {
        return reservedAmount;
    }

    public BigDecimal getReleasedAmount() {
        return releasedAmount;
    }
}
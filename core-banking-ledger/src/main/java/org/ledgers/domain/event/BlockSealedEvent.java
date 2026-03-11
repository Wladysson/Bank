package com.bank.ledger.domain.event;

import com.bank.ledger.domain.model.Block;
import java.time.Instant;
import java.util.UUID;

public class BlockSealedEvent {
    private final UUID eventId;
    private final Block block;
    private final Instant occurredAt;

    public BlockSealedEvent(Block block) {
        this.eventId = UUID.randomUUID();
        this.block = block;
        this.occurredAt = Instant.now();
    }

    public UUID getEventId() {
        return eventId;
    }

    public Block getBlock() {
        return block;
    }

    public Instant getOccurredAt() {
        return occurredAt;
    }
}
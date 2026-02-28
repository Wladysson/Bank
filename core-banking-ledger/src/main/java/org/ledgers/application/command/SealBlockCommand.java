package com.bank.ledger.application.command;

import java.time.LocalDateTime;
import java.util.UUID;

public class SealBlockCommand {

    private final UUID blockId;
    private final LocalDateTime sealedAt;

    public SealBlockCommand(UUID blockId, LocalDateTime sealedAt) {
        this.blockId = blockId;
        this.sealedAt = sealedAt;
    }

    public UUID getBlockId() {
        return blockId;
    }

    public LocalDateTime getSealedAt() {
        return sealedAt;
    }
}
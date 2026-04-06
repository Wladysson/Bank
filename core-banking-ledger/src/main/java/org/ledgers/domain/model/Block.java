package com.bank.ledger.domain.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {

    private final UUID id;
    private final List<LedgerEntry> ledgerEntries;
    private final Instant createdAt;
    private boolean sealed;
    private String hash;

    public Block(List<LedgerEntry> ledgerEntries) {
        this.id = UUID.randomUUID();
        this.ledgerEntries = ledgerEntries;
        this.createdAt = Instant.now(); // registra a criação
        this.sealed = false;
        this.hash = null;
    }

    public UUID getId() {
        return id;
    }

    public List<LedgerEntry> getLedgerEntries() {
        return ledgerEntries;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public boolean isSealed() {
        return sealed;
    }

    public void setSealed(boolean sealed) {
        this.sealed = sealed;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    // gerar hash das entradas (JSON ou string concatenada)
    public String getEntriesHash() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            StringBuilder sb = new StringBuilder();
            for (LedgerEntry entry : ledgerEntries) {
                sb.append(entry.getId())
                        .append(entry.getAccountId())
                        .append(entry.getAmount())
                        .append(entry.getType())
                        .append(entry.getCreatedAt());
            }
            byte[] hashBytes = digest.digest(sb.toString().getBytes());
            StringBuilder hex = new StringBuilder();
            for (byte b : hashBytes) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash do bloco", e);
        }
    }
}
package com.bank.account.domain.model;

import java.time.Instant;
import java.util.Map;
import java.util.Objects;

 //Value Object que representa metadados da conta
 //Armazena informações auxiliares não estruturais do domínio principal
public final class AccountMetadata {

    private final Map<String, String> metadata;
    private final Instant createdAt;

    private AccountMetadata(Map<String, String> metadata, Instant createdAt) {
        this.metadata = Map.copyOf(metadata); // garante imutabilidade dos metadados
        this.createdAt = createdAt;
    }

    public static AccountMetadata of(Map<String, String> metadata) {
        if (metadata == null) { // valida presença de metadata
            throw new IllegalArgumentException("AccountMetadata cannot be null");
        }

        return new AccountMetadata(metadata, Instant.now()); // registra momento de criação
    }

    public String get(String key) {
        return metadata.get(key); // acessa valor específico do metadata
    }

    public Map<String, String> getAll() {
        return metadata; // retorna cópia imutável dos metadados
    }

    public Instant getCreatedAt() {
        return createdAt; // timestamp de criação do metadata
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // comparação por referência
        if (!(o instanceof AccountMetadata)) return false;
        AccountMetadata that = (AccountMetadata) o;
        return Objects.equals(metadata, that.metadata) &&
                Objects.equals(createdAt, that.createdAt); // comparação completa
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadata, createdAt); // hash baseado em dados + tempo
    }

    @Override
    public String toString() {
        return metadata.toString(); // representação simplificada dos metadados
    }
}
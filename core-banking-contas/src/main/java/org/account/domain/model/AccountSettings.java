package com.bank.account.domain.model;

import java.util.Map;
import java.util.Objects;

 //Value Object que representa configurações da conta
 //Centraliza parâmetros comportamentais e regras operacionais da conta

public final class AccountSettings {

    private final Map<String, Object> settings;

    private AccountSettings(Map<String, Object> settings) {
        this.settings = Map.copyOf(settings); // garante imutabilidade do mapa
    }

    public static AccountSettings of(Map<String, Object> settings) {
        if (settings == null || settings.isEmpty()) { // valida se existem configurações
            throw new IllegalArgumentException("AccountSettings cannot be null or empty");
        }

        return new AccountSettings(settings);
    }

    public Object get(String key) {
        return settings.get(key); // acessa configuração específica
    }

    public Map<String, Object> getAll() {
        return settings; // expõe cópia imutável das configurações
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // comparação por referência
        if (!(o instanceof AccountSettings)) return false;
        AccountSettings that = (AccountSettings) o;
        return Objects.equals(settings, that.settings); // comparação por conteúdo
    }

    @Override
    public int hashCode() {
        return Objects.hash(settings); // hash baseado no conjunto de settings
    }

    @Override
    public String toString() {
        return settings.toString(); // representação das configurações
    }
}
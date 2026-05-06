package com.bank.transactions.domain.model;

import java.util.Objects;

public class PixKey {

    private final String value;
    private final PixKeyType type;

    public PixKey(String value, PixKeyType type) {
        this.value = normalize(Objects.requireNonNull(value, "Pix key value must not be null"));
        this.type = Objects.requireNonNull(type, "Pix key type must not be null");
    }

    public String getValue() {
        return value;
    }

    public PixKeyType getType() {
        return type;
    }

    // 🔐 Valor mascarado para exibição segura
    public String getMaskedValue() {
        if (value.length() < 4) {
            return "****";
        }

        return switch (type) {
            case EMAIL -> maskEmail(value);
            case PHONE -> maskPhone(value);
            case CPF, CNPJ -> maskDocument(value);
            case RANDOM -> "****" + last4();
        };
    }

    private String last4() {
        return value.substring(Math.max(0, value.length() - 4));
    }

    private String maskEmail(String email) {
        int atIndex = email.indexOf("@");

        if (atIndex <= 2) {
            return "***" + email.substring(atIndex);
        }

        return email.substring(0, 2) + "***" + email.substring(atIndex);
    }

    private String maskPhone(String phone) {
        return "****" + last4();
    }

    private String maskDocument(String document) {
        return "***" + last4();
    }

    // 🔧 Normalização (muito importante em sistema financeiro)
    private String normalize(String value) {
        return value.trim();
    }

    @Override
    public String toString() {
        // ⚠️ Nunca expor valor sensível completo em logs
        return getMaskedValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PixKey pixKey)) return false;
        return value.equals(pixKey.value) && type == pixKey.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }
}
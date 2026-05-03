package com.bank.payments.domain.model;

import java.util.Objects;

public class PixKey {

    private final String value;
    private final PixKeyType type;

    public PixKey(String value, PixKeyType type) {
        this.value = Objects.requireNonNull(value, "Pix key value must not be null");
        this.type = Objects.requireNonNull(type, "Pix key type must not be null");
    }

    public String getValue() {
        return value;
    }

    public PixKeyType getType() {
        return type;
    }

    public String getMaskedValue() {
        if (value == null || value.length() < 4) {
            return "****";
        }

        return switch (type) {
            case EMAIL -> maskEmail(value);
            case PHONE -> maskPhone(value);
            case CPF, CNPJ -> maskDocument(value);
            case RANDOM -> "****" + value.substring(Math.max(0, value.length() - 4));
        };
    }

    private String maskEmail(String email) {
        int atIndex = email.indexOf("@");

        if (atIndex <= 2) {
            return "***" + email.substring(atIndex);
        }

        return email.substring(0, 2) + "***" + email.substring(atIndex);
    }

    private String maskPhone(String phone) {
        return "****" + phone.substring(Math.max(0, phone.length() - 4));
    }

    private String maskDocument(String document) {
        return "***" + document.substring(Math.max(0, document.length() - 4));
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PixKey pixKey)) return false;
        return Objects.equals(value, pixKey.value) && type == pixKey.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }
}
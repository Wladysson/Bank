package com.bank.transactions.domain.model.pix;

// Value Object responsável pela chave PIX
public class PixKey {

    // Valor da chave PIX
    private final String value;

    // Tipo da chave PIX
    private final PixKeyType type;

    public PixKey(String value, PixKeyType type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public PixKeyType getType() {
        return type;
    }
}
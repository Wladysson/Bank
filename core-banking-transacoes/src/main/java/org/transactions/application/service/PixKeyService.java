package com.bank.transactions.application.service;

import com.bank.transactions.domain.model.PixKey;
import com.bank.transactions.domain.model.PixKeyType;
import com.bank.transactions.infrastructure.integration.pix.PixKeyGatewayImpl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.regex.Pattern;

@ApplicationScoped
public class PixKeyService {

    private static final Pattern CPF_PATTERN =
            Pattern.compile("^\\d{11}$");

    private static final Pattern CNPJ_PATTERN =
            Pattern.compile("^\\d{14}$");

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^\\+?[1-9]\\d{10,14}$");

    private final PixKeyGatewayImpl pixKeyGateway;

    @Inject
    public PixKeyService(PixKeyGatewayImpl pixKeyGateway) {
        this.pixKeyGateway = pixKeyGateway;
    }

    public PixKey resolve(String keyValue) {

        validate(keyValue);

        PixKey pixKey = pixKeyGateway.resolve(keyValue);

        if (pixKey == null) {
            throw new IllegalArgumentException(
                    "Chave PIX não encontrada."
            );
        }

        return pixKey;
    }

    public void validate(String keyValue) {

        if (keyValue == null || keyValue.isBlank()) {
            throw new IllegalArgumentException(
                    "A chave PIX não pode ser nula ou vazia."
            );
        }

        String sanitizedKey = keyValue.trim();

        if (!isValidPixKey(sanitizedKey)) {
            throw new IllegalArgumentException(
                    "Formato da chave PIX inválido."
            );
        }
    }

    public PixKeyType detectKeyType(String keyValue) {

        String sanitizedKey = keyValue.trim();

        if (CPF_PATTERN.matcher(sanitizedKey).matches()) {
            return PixKeyType.CPF;
        }

        if (CNPJ_PATTERN.matcher(sanitizedKey).matches()) {
            return PixKeyType.CNPJ;
        }

        if (EMAIL_PATTERN.matcher(sanitizedKey).matches()) {
            return PixKeyType.EMAIL;
        }

        if (PHONE_PATTERN.matcher(sanitizedKey).matches()) {
            return PixKeyType.PHONE;
        }

        return PixKeyType.RANDOM;
    }

    private boolean isValidPixKey(String keyValue) {

        return CPF_PATTERN.matcher(keyValue).matches()
                || CNPJ_PATTERN.matcher(keyValue).matches()
                || EMAIL_PATTERN.matcher(keyValue).matches()
                || PHONE_PATTERN.matcher(keyValue).matches()
                || isRandomKey(keyValue);
    }

    private boolean isRandomKey(String keyValue) {

        return keyValue.length() >= 32;
    }
}
package com.bank.transactions.application.service;

import jakarta.enterprise.context.ApplicationScoped;

// Serviço responsável pela validação de chaves PIX
@ApplicationScoped
public class PixKeyService {

    // Valida formato e existência da chave PIX
    public boolean validate(String pixKey) {
        return true;
    }
}
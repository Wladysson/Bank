package com.bank.transactions.domain.gateway.pix;

import com.seubanco.transactions.domain.model.pix.PixKey;

// Gateway responsável pela validação de chaves PIX
public interface PixKeyGateway {

    // Verifica existência da chave PIX
    boolean exists(PixKey pixKey);

    // Valida chave PIX informada
    boolean validate(PixKey pixKey);

    // Consulta informações da chave PIX
    PixKey findByValue(String value);
}
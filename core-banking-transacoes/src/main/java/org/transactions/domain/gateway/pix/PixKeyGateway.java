package com.bank.transactions.domain.gateway.pix;

import com.bank.transactions.domain.model.pix.PixKey;
import com.bank.transactions.domain.model.pix.PixKeyType;

import java.util.Optional;

public interface PixKeyGateway {

    Optional<PixKey> findByValue(String value);

    boolean validateKey(String key, PixKeyType type);
}
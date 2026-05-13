package com.bank.transactions.domain.gateway;

import com.bank.transactions.domain.model.PixKey;

public interface PixKeyGateway {

    PixKey resolve(String keyValue);
}
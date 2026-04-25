package com.bank.payments.domain.repository;

import com.bank.payments.domain.model.Boleto;

import java.util.Optional;

public interface BoletoRepository {

    Boleto save(Boleto boleto);

    Optional<Boleto> findById(String id);
}
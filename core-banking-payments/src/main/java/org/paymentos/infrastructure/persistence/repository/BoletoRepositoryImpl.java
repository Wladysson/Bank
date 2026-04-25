package com.bank.payments.infrastructure.persistence.repository;

import com.bank.payments.domain.model.Boleto;
import com.bank.payments.domain.model.BoletoStatus;
import com.bank.payments.domain.repository.BoletoRepository;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class BoletoRepositoryImpl implements BoletoRepository {

    private final Map<String, Boleto> storage = new ConcurrentHashMap<>();

    public BoletoRepositoryImpl() {
        Boleto sample = new Boleto(
                "BOL-001",
                "João Silva",
                "12345678900",
                new BigDecimal("150.00"),
                LocalDate.now().plusDays(5),
                "34191790010104351004791020150008291070000015000",
                "34191.79001 01043.510047 91020.150008 2 91070000015000",
                "Empresa XYZ Ltda",
                BoletoStatus.ISSUED
        );

        storage.put(sample.getId(), sample);
    }

    @Override
    public Boleto save(Boleto boleto) {
        storage.put(boleto.getId(), boleto);
        return boleto;
    }

    @Override
    public Optional<Boleto> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }
}
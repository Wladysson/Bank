package com.bank.ledger.domain.repository;

import com.bank.ledger.domain.model.Block;

import java.util.Optional;
import java.util.UUID;

public interface BlockRepository {

    void save(Block block);

    Optional<Block> findById(UUID id);

    Iterable<Block> findAll();
}
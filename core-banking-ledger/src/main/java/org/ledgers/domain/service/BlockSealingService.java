package com.bank.ledger.domain.service;

import com.bank.ledger.domain.model.Block;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class BlockSealingService {

    public void seal(Block block) {

        if (block.isSealed()) {
            throw new IllegalStateException("O bloco ja esta selado.");
        }

        String contentToHash = block.getId().toString() +
                block.getCreatedAt().toString() +
                block.getEntriesHash();

        String hash = generateHash(contentToHash);

        block.setHash(hash);
        block.setSealed(true);
    }

    private String generateHash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro na geraçao o hash do bloco", e);
        }
    }
}

public class

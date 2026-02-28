package com.bank.ledger.application.service;

import com.bank.ledger.application.command.PostJournalCommand;
import com.bank.ledger.application.command.SealBlockCommand;
import com.bank.ledger.domain.model.Block;
import com.bank.ledger.domain.repository.BlockRepository;
import com.bank.ledger.domain.service.BlockSealingService;

import java.util.UUID;

public class LedgerApplicationService {

    private final JournalPostingService journalPostingService;
    private final BlockRepository blockRepository;
    private final BlockSealingService blockSealingService;

    public LedgerApplicationService(
            JournalPostingService journalPostingService,
            BlockRepository blockRepository,
            BlockSealingService blockSealingService
    ) {
        this.journalPostingService = journalPostingService;
        this.blockRepository = blockRepository;
        this.blockSealingService = blockSealingService;
    }

    public UUID postJournal(PostJournalCommand command) {
        return journalPostingService.post(command);
    }

    public void sealBlock(SealBlockCommand command) {

        Block block = blockRepository.findById(command.getBlockId())
                .orElseThrow(() -> new IllegalArgumentException("Bloco nao Encontrado"));

        blockSealingService.seal(block);

        blockRepository.save(block);
    }
}
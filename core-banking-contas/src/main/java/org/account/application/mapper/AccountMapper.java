package com.bank.account.account.application.mapper;

import com.bank.account.account.application.dto.AccountDetailDTO;
import com.bank.account.account.application.dto.AccountSummaryDTO;
import com.bank.account.domain.model.Account;

import java.util.stream.Collectors;

public final class AccountMapper {

    private AccountMapper() {
        // impede instanciação da classe utilitária
    }

    public static AccountSummaryDTO toSummary(Account account) {

        AccountSummaryDTO dto = new AccountSummaryDTO();

        dto.setAccountId(account.getAccountId().toString()); // converte UUID para String
        dto.setAccountNumber(account.getAccountNumber()); // já é String
        dto.setAccountType(account.getType()); // obtém tipo da conta
        dto.setStatus(account.getStatus()); // preenche status atual

        if (!account.getHolders().isEmpty()) {
            dto.setPrimaryHolderName(account.getHolders().get(0).toString()); // primeiro titular como principal
        }

        return dto;
    }

    public static AccountDetailDTO toDetail(Account account) {

        AccountDetailDTO dto = new AccountDetailDTO();

        dto.setAccountId(account.getAccountId().toString()); // converte UUID para String
        dto.setAccountNumber(account.getAccountNumber()); // já é String
        dto.setBranchCode("DEFAULT"); // valor padrão caso não exista método
        dto.setAccountType(account.getType()); // preenche tipo
        dto.setStatus(account.getStatus()); // preenche status
        dto.setCreatedAt(null); // não há método getCreatedAt no Account

        dto.setHolders(
                account.getHolders()
                        .stream()
                        .map(Object::toString)
                        .collect(Collectors.toList())
        ); // converte titulares para lista de representações em string

        return dto;
    }
}
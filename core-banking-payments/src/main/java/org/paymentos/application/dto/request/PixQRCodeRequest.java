package com.bank.payments.application.dto.request;

import com.bank.payments.domain.model.PixTransactionType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record PixQRCodeRequest(
        @NotBlank String beneficiaryName,
        @NotBlank String beneficiaryPixKey,
        @NotNull @DecimalMin("0.01") BigDecimal amount,
        String description,
        @NotNull PixTransactionType transactionType,
        Integer expirationInSeconds
) {}
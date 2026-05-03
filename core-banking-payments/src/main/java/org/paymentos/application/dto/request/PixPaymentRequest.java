package com.bank.payments.application.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

public record PixPaymentRequest(
        @NotBlank(message = "O ID da transação é obrigatório")
        String transactionId,

        @NotNull(message = "É necessário informar o valor.")
        @DecimalMin(value = "0.01", message = "O valor deve ser maior que zero.")
        BigDecimal amount,

        @NotNull(message = "É necessário o ID da conta do pagador.")
        UUID payerAccountId,

        @NotBlank(message = "É necessária uma chave PIX.")
        String pixKey,

        @NotBlank(message = "O nome do destinatário é obrigatório.")
        String receiverName,

        @Size(max = 140, message = "A descrição deve ter no máximo 140 caracteres.")
        String description
) {}
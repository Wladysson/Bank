package com.bank.payments.application.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record PixRefundRequest(
        @NotNull UUID originalPaymentId,
        @NotNull @DecimalMin("0.01") BigDecimal amount,
        @NotBlank String reason,
        String requestedBy
) {}

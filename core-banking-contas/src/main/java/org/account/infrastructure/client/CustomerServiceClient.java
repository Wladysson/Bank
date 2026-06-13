package com.bank.account.infrastructure.client;

import com.bank.account.domain.model.CustomerId;

import java.util.Optional;

public interface CustomerServiceClient {

    Optional<CustomerProfile> findById(
            CustomerId customerId
    ); // consulta dados cadastrais do cliente

    boolean exists(
            CustomerId customerId
    ); // verifica existência do cliente

    boolean isActive(
            CustomerId customerId
    ); // verifica se o cliente está ativo

    boolean isEligibleForAccountOpening(
            CustomerId customerId
    ); // valida elegibilidade para abertura de conta
}
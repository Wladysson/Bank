package com.bank.account.infrastructure.client;

import com.bank.account.domain.model.CustomerId;

public class CustomerProfile {

    private CustomerId customerId;
    private String name;
    private String email;
    private String phone;
    private String cpfCnpj;
    private boolean active;
    private String registrationStatus;

    public CustomerProfile() {
    }

    public CustomerProfile(
            CustomerId customerId,
            String name,
            String email,
            String phone,
            String cpfCnpj,
            boolean active,
            String registrationStatus
    ) {
        this.customerId = customerId; // identifica o cliente
        this.name = name; // nome do cliente
        this.email = email; // email do cliente
        this.phone = phone; // telefone do cliente
        this.cpfCnpj = cpfCnpj; // documento do cliente
        this.active = active; // status de atividade
        this.registrationStatus = registrationStatus; // status do cadastro
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerId customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }
}

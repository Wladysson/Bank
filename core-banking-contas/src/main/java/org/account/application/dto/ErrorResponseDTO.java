
package com.bank.account.application.dto;

import java.time.Instant;
import java.util.List;

public class ErrorResponseDTO {

    private String code;
    private String message;
    private List<String> details;
    private Instant timestamp;

    public String getCode() {
        return code; // código do erro
    }

    public void setCode(String code) {
        this.code = code; // define código do erro
    }

    public String getMessage() {
        return message; // mensagem principal
    }

    public void setMessage(String message) {
        this.message = message; // define mensagem
    }

    public List<String> getDetails() {
        return details; // detalhes adicionais
    }

    public void setDetails(List<String> details) {
        this.details = details; // define detalhes
    }

    public Instant getTimestamp() {
        return timestamp; // data do erro
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp; // define timestamp
    }
}
package com.bank.account.interfaces.rest.response;

import java.time.LocalDateTime;
import java.util.List;

public class ApiErrorResponse {

    private String code; // código funcional do erro

    private String message; // mensagem principal

    private String path; // endpoint que gerou o erro

    private LocalDateTime timestamp; // momento da ocorrência

    private List<String> details; // detalhes adicionais de validação

    public ApiErrorResponse() {
    }

    public ApiErrorResponse(
            String code,
            String message,
            String path,
            LocalDateTime timestamp,
            List<String> details
    ) {
        this.code = code;
        this.message = message;
        this.path = path;
        this.timestamp = timestamp;
        this.details = details;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}
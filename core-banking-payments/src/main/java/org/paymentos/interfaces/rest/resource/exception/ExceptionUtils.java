package com.bank.payments.interfaces.rest.exception;

public class ExceptionUtils {

    public static ErrorResponse build(ErrorCode code, String message) {
        return new ErrorResponse(code.name(), message);
    }
}
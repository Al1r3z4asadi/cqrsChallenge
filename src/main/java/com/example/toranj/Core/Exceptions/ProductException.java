package com.example.toranj.Core.Exceptions;

public class ProductException extends RuntimeException {

    private String errorCode;

    public ProductException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

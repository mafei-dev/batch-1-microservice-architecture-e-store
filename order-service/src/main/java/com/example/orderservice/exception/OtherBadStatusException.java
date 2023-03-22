package com.example.orderservice.exception;

public class OtherBadStatusException extends RuntimeException{
    public OtherBadStatusException() {
    }

    public OtherBadStatusException(String message) {
        super(message);
    }

    public OtherBadStatusException(String message, Throwable cause) {
        super(message, cause);
    }

    public OtherBadStatusException(Throwable cause) {
        super(cause);
    }

    public OtherBadStatusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

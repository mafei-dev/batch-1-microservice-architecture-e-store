package com.example.orderservice.exception;

public class ServerUnavailableException extends RuntimeException {
    public ServerUnavailableException() {
    }

    public ServerUnavailableException(String message) {
        super(message);
    }

    public ServerUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerUnavailableException(Throwable cause) {
        super(cause);
    }

    public ServerUnavailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

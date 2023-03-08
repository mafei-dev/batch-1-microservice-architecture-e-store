package com.example.paymentservice.exception;

import lombok.Getter;

@Getter
public class PaymentNotFoundException extends RuntimeException {

    private final String paymentId;

    public PaymentNotFoundException(String paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentNotFoundException(String message, String paymentId) {
        super(message);
        this.paymentId = paymentId;
    }
}

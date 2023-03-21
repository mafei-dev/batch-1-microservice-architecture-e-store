package com.example.orderservice.tmp;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class PaymentServiceBH {


    @Bulkhead(name = "getPayment", type = Bulkhead.Type.SEMAPHORE)
    public String getPayment(String paymentId) {
        System.out.println("PaymentServiceBH:getPayment:Thread:" + Thread.currentThread().getName() + ",paymentId:" + paymentId);
        Sleep.sleepMe(2_000);
        return paymentId;
    }

    @Bulkhead(name = "getPaymentTHREADPOOL", type = Bulkhead.Type.THREADPOOL)
    public CompletableFuture<String> getPaymentTHREADPOOL(String paymentId) {
        System.out.println("PaymentServiceBH:getPaymentTHREADPOOL:Thread:" + Thread.currentThread().getName() + ",paymentId:" + paymentId);
        Sleep.sleepMe(2_000);
        return CompletableFuture.completedFuture(paymentId);
    }



   /* @FallbackMethod
    public String getPaymentFallback(String paymentId, Exception exception) {
        System.err.println(exception.getMessage());
        System.out.println("PaymentServiceBH:getPaymentFallback:Thread:" + Thread.currentThread().getName() + ",paymentId:" + paymentId);
        return "I am from fallback method.";
    }*/
}

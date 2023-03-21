package com.example.orderservice.tmp;

import com.example.orderservice.utl.FallbackMethod;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@AllArgsConstructor
public class PaymentServiceBH {


    @Bulkhead(name = "getPayment", type = Bulkhead.Type.SEMAPHORE)
    public String getPayment(String paymentId) {
        System.out.println("PaymentServiceBH:getPayment:Thread:" + Thread.currentThread().getName() + ",paymentId:" + paymentId);
        Sleep.sleepMe(2_000);
        return paymentId;
    }

   /* @FallbackMethod
    public String getPaymentFallback(String paymentId, Exception exception) {
        System.err.println(exception.getMessage());
        System.out.println("PaymentServiceBH:getPaymentFallback:Thread:" + Thread.currentThread().getName() + ",paymentId:" + paymentId);
        return "I am from fallback method.";
    }*/
}

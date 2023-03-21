package com.example.orderservice.controller;

import com.example.orderservice.tmp.PaymentServiceBH;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/bulkhead")
@AllArgsConstructor
public class BulkheadTestController {

    private final PaymentServiceBH paymentService;

    @GetMapping("/{paymentId}")
    public Map<String, String> testBH(@PathVariable String paymentId) {
        System.out.println("BulkheadTestController:testBH:Thread:" + Thread.currentThread().getName());
        return Collections.singletonMap(
                "name",
                this.paymentService.getPayment(paymentId)
        );
    }
}
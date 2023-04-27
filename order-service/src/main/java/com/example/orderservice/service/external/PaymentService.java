package com.example.orderservice.service.external;

import com.example.orderservice.modal.GetPaymentDetailResponseModal;
import com.example.orderservice.modal.MakePaymentRequestModal;
import com.example.orderservice.modal.MakePaymentResponseModal;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "PAYMENT-SERVICE", path = "/payment")
public interface PaymentService {

    @PostMapping
    ResponseEntity<MakePaymentResponseModal> makePayment(@RequestBody MakePaymentRequestModal modal);

    //PaymentServicegetPaymentDetail //imagine
    //PaymentService#getPaymentDetail(String)
    //PaymentService#getPaymentDetail(String)(String)
    @GetMapping("/{payment_id}")
    GetPaymentDetailResponseModal getPaymentDetail(@PathVariable("payment_id") String paymentId);

}


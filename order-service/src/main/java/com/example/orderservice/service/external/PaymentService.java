package com.example.orderservice.service.external;

import com.example.orderservice.modal.GetPaymentDetailResponseModal;
import com.example.orderservice.modal.MakePaymentRequestModal;
import com.example.orderservice.modal.MakePaymentResponseModal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-SERVICE", path = "/payment")
public interface PaymentService {
    @PostMapping
    ResponseEntity<MakePaymentResponseModal> makePayment(@RequestBody MakePaymentRequestModal modal);

    @GetMapping("/{payment_id}")
    GetPaymentDetailResponseModal getPaymentDetail(@PathVariable("payment_id") String paymentId);

}


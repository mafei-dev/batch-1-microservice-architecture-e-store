package com.example.orderservice.service.external;

import com.example.orderservice.modal.GetPaymentDetailResponseModal;
import com.example.orderservice.modal.MakePaymentRequestModal;
import com.example.orderservice.modal.MakePaymentResponseModal;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-SERVICE", path = "/payment", fallbackFactory = PaymentService.PaymentServiceFallBack.class)
public interface PaymentService {
    @PostMapping
    ResponseEntity<MakePaymentResponseModal> makePayment(@RequestBody MakePaymentRequestModal modal);

    @GetMapping("/{payment_id}")
    GetPaymentDetailResponseModal getPaymentDetail(@PathVariable("payment_id") String paymentId);


    @Component
    class PaymentServiceFallBack implements FallbackFactory<PaymentService> {

        @Override
        public PaymentService create(Throwable cause) {
            return new PaymentService() {

                @Override
                public ResponseEntity<MakePaymentResponseModal> makePayment(MakePaymentRequestModal modal) {
                    System.out.println(this);
                    return null;
                }

                @Override
                public GetPaymentDetailResponseModal getPaymentDetail(String paymentId) {
                    System.out.println("PaymentServiceFallBack.getPaymentDetail");
                    System.out.println(this);
                    cause.printStackTrace();
//                    return GetPaymentDetailResponseModal.builder().build();
                    throw new RuntimeException(cause);
                }
            };
        }
    }
}


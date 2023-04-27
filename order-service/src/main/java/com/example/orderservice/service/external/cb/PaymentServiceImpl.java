package com.example.orderservice.service.external.cb;

import com.example.orderservice.exception.OtherBadStatusException;
import com.example.orderservice.exception.ServerUnavailableException;
import com.example.orderservice.modal.GetPaymentDetailResponseModal;
import com.example.orderservice.modal.MakePaymentRequestModal;
import com.example.orderservice.modal.MakePaymentResponseModal;
import com.example.orderservice.service.external.PaymentService;
import com.example.orderservice.utl.FallbackMethod;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentService paymentService;

    @Override
    public ResponseEntity<MakePaymentResponseModal> makePayment(MakePaymentRequestModal modal) {
        System.out.println("PaymentServiceImpl.makePayment");
        return paymentService.makePayment(modal);
    }

    @Override
    @CircuitBreaker(name = "getPaymentDetail", fallbackMethod = "getPaymentDetailFallback")
    public GetPaymentDetailResponseModal getPaymentDetail(String paymentId) {
        System.out.println("PaymentServiceImpl.getPaymentDetail");
        try {
            return paymentService.getPaymentDetail(paymentId);
        } catch (FeignException e) {
            e.printStackTrace();
            if (e.status() == HttpStatus.SERVICE_UNAVAILABLE.value()) {
                System.err.println("HttpStatus.SERVICE_UNAVAILABLE");
                throw new ServerUnavailableException("Payment SERVICE_UNAVAILABLE");
            } else {
                throw new OtherBadStatusException(e);
            }
        }
    }


    @FallbackMethod
    public GetPaymentDetailResponseModal getPaymentDetailFallback(String paymentId, Exception exception) {
        System.out.println("PaymentServiceImpl.getPaymentDetailFallback");
        /*if (exception instanceof CallNotPermittedException){

        }else {

        }*/
        exception.printStackTrace();
        return null;
    }
}

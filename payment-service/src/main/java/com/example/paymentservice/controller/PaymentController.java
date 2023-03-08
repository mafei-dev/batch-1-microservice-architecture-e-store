package com.example.paymentservice.controller;

import com.example.paymentservice.dto.MakePaymentRequestDto;
import com.example.paymentservice.dto.PaymentDetailRequestDto;
import com.example.paymentservice.modal.GetPaymentDetailRequestModal;
import com.example.paymentservice.modal.GetPaymentDetailRequestModalModal;
import com.example.paymentservice.modal.MakePaymentRequestModal;
import com.example.paymentservice.modal.MakePaymentResponseModal;
import com.example.paymentservice.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;


    @PostMapping
    public Mono<ResponseEntity<MakePaymentResponseModal>> makePayment(
            @RequestBody MakePaymentRequestModal modal
    ) {
        return Mono
                .just(modal)
                .map(requestModal -> MakePaymentRequestDto.builder()
                        .orderId(requestModal.getOrderId())
                        .amount(requestModal.getAmount())
                        .username(requestModal.getUsername())
                        .build()
                )
                .flatMap(this.paymentService::makePayment)
                .map(makePaymentResponseDto -> MakePaymentResponseModal.builder()
                        .paymentId(makePaymentResponseDto.getPaymentId())
                        .build()
                )
                // TODO: 3/8/2023 catch the error
                .map(ResponseEntity::ok);
    }


    @GetMapping("/{payment_id}")
    public Mono<ResponseEntity<GetPaymentDetailRequestModalModal>> getPaymentDetail(@PathVariable("payment_id") String paymentId) {
        return this.paymentService
                .getPaymentDetail(
                        PaymentDetailRequestDto.builder()
                                .paymentId(paymentId)
                                .build()
                )
                .map(responseDto -> GetPaymentDetailRequestModalModal.builder()
                        .paymentId(responseDto.getPaymentId())
                        .amount(responseDto.getAmount())
                        .paymentStatus(responseDto.getPaymentStatus())
                        .addedDatetime(responseDto.getAddedDatetime())
                        .build()
                )
                // TODO: 3/8/2023 catch the error
                .map(ResponseEntity::ok);

    }
}

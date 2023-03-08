package com.example.paymentservice.service;

import com.example.paymentservice.dto.MakePaymentRequestDto;
import com.example.paymentservice.dto.MakePaymentResponseDto;
import com.example.paymentservice.dto.PaymentDetailRequestDto;
import com.example.paymentservice.dto.PaymentDetailResponseDto;
import com.example.paymentservice.entity.OrderPaymentEntity;
import com.example.paymentservice.exception.PaymentNotFoundException;
import com.example.paymentservice.modal.GetPaymentDetailRequestModal;
import com.example.paymentservice.repository.OrderPaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PaymentService {
    private final OrderPaymentRepository orderPaymentRepository;


    public Mono<MakePaymentResponseDto> makePayment(MakePaymentRequestDto requestDto) {
        //b:logic
        return this.orderPaymentRepository
                .save(
                        OrderPaymentEntity.builder()
                                .paymentId(null)
                                .paymentStatus(OrderPaymentEntity.PaymentStatus.SUCCESS)
                                .addDatetime(LocalDateTime.now())
                                .username(requestDto.getUsername())
                                .amount(requestDto.getAmount())
                                .orderId(requestDto.getOrderId())
                                .build()
                )
                .map(orderPaymentEntity -> MakePaymentResponseDto.builder()
                        .paymentId(String.valueOf(orderPaymentEntity.getPaymentId()))
                        .build()
                );
    }


    public Mono<PaymentDetailResponseDto> getPaymentDetail(PaymentDetailRequestDto requestDto) {
        return this.orderPaymentRepository
                .findById(Long.valueOf(requestDto.getPaymentId()))
                .switchIfEmpty(
                        Mono.error(
                                new PaymentNotFoundException(
                                        String.format("A payment record doesnt exist for %s.", requestDto.getPaymentId()),
                                        requestDto.getPaymentId()
                                )
                        )
                )
                .map(orderPaymentEntity -> PaymentDetailResponseDto.builder()
                        .addedDatetime(orderPaymentEntity.getAddDatetime())
                        .amount(orderPaymentEntity.getAmount())
                        .paymentId(orderPaymentEntity.getPaymentId())
                        .paymentStatus(orderPaymentEntity.getPaymentStatus())
                        .build()
                );
    }


}

package com.example.orderservice.service;

import com.example.orderservice.dto.PlaceOrderRequestDto;
import com.example.orderservice.dto.PlaceOrderResponseDto;
import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.entity.OrderStatusEntity;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.mapper.OrderStatusMapper;
import com.example.orderservice.modal.MakePaymentRequestModal;
import com.example.orderservice.modal.MakePaymentResponseModal;
import com.example.orderservice.modal.UserDetailModal;
import com.example.orderservice.service.external.PaymentService;
import com.example.orderservice.service.external.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderStatusMapper orderStatusMapper;
    private final UserService userService;
    private final PaymentService paymentService;


    @Transactional
    public PlaceOrderResponseDto makeOrder(PlaceOrderRequestDto requestDto) {
        UserDetailModal userDetailModal;
        LocalDateTime now = LocalDateTime.now();
        {
            //user-service [external]
            ResponseEntity<UserDetailModal> userDetail = this.userService.getUserDetail(requestDto.getUsername());
            if (userDetail.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                throw new RuntimeException("User not found.");
            }
            userDetailModal = Objects.requireNonNull(userDetail.getBody());
            if (userDetailModal.getIsActive() != 1) {
                throw new RuntimeException("User is not eligible for buying.");
            }
        }
        String orderId;
        {
            //order-service [Internal-service]

            orderId = UUID.randomUUID().toString();
            this.orderMapper.save(
                    OrderEntity.builder()
                            .orderId(orderId)
                            .orderDate(now)
                            .username(requestDto.getUsername())
                            .amount(requestDto.getAmount())
                            .transactionId(null)
                            .build()
            );
        }
        String paymentId;
        {
            //payment-service [external]
            ResponseEntity<MakePaymentResponseModal> paymentResponse = this.paymentService.makePayment(MakePaymentRequestModal
                    .builder()
                    .username(requestDto.getUsername())
                    .amount(requestDto.getAmount())
                    .orderId(orderId)
                    .build()
            );
            if (!paymentResponse.getStatusCode().equals(HttpStatus.OK)) {
                throw new RuntimeException("payment failed.");
            } else {
                paymentId = Objects.requireNonNull(paymentResponse.getBody()).getPaymentId();
            }
        }


        {
            //order-service [Internal-service]
            this.orderStatusMapper.save(
                    OrderStatusEntity.builder()
                            .orderStatusId(UUID.randomUUID().toString())
                            .updateDate(now)
                            .status("SUCCESS")
                            .orderId(orderId)
                            .build()
            );
        }

        {
            this.orderMapper.updateTransactionData(orderId, paymentId);
        }
        return PlaceOrderResponseDto
                .builder()
                .orderId(orderId)
                .build();
    }
}

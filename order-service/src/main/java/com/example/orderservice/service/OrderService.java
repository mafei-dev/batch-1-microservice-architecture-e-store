package com.example.orderservice.service;

import com.example.orderservice.dto.PlaceOrderRequestDto;
import com.example.orderservice.dto.PlaceOrderResponseDto;
import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.entity.OrderStatusEntity;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.mapper.OrderStatusMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderStatusMapper orderStatusMapper;


    @Transactional
    public PlaceOrderResponseDto makeOrder(PlaceOrderRequestDto requestDto) {
        //user-service [external]

        LocalDateTime now = LocalDateTime.now();
        String orderId = UUID.randomUUID().toString();
        this.orderMapper.save(
                OrderEntity.builder()
                        .orderId(orderId)
                        .orderDate(now)
                        .username(requestDto.getUsername())
                        .amount(requestDto.getAmount())
                        .transactionId(null)
                        .build()
        );

        //payment-service [external]

        this.orderStatusMapper.save(
                OrderStatusEntity.builder()
                        .orderStatusId(UUID.randomUUID().toString())
                        .updateDate(now)
                        .status("SUCCESS")
                        .orderId(orderId)
                        .build()
        );
        return PlaceOrderResponseDto
                .builder()
                .orderId(orderId)
                .build();
    }
}

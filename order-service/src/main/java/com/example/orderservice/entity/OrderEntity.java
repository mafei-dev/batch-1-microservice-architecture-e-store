package com.example.orderservice.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    private String orderId;
    private LocalDateTime orderDate;
    private String username;
    private Double amount;
    private String transactionId;
}

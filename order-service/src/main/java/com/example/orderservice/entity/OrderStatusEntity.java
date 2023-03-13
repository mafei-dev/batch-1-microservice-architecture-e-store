package com.example.orderservice.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatusEntity {
    private String orderStatusId;
    private LocalDateTime updateDate;
    private String status;
    private String orderId;
}

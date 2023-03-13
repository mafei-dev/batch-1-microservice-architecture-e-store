package com.example.orderservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaceOrderRequestDto {
    private String username;
    private Double amount;
}

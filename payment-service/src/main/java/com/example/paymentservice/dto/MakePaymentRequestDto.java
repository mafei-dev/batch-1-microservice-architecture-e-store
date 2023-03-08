package com.example.paymentservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MakePaymentRequestDto {
    private String username;
    private Double amount;
    private String orderId;

}

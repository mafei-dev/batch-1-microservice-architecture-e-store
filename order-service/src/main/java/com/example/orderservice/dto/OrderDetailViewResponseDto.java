package com.example.orderservice.dto;

import com.example.orderservice.modal.GetPaymentDetailResponseModal;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailViewResponseDto {


    private String orderId;
    private LocalDateTime orderDate;
    private String username;
    private Double amount;
    private String transactionId;


    private String orderStatusId;
    private LocalDateTime updateDate;
    private String status;
    private GetPaymentDetailResponseModal paymentDetail;

    private final Map<String, String> serviceStatus = new HashMap<>();

}

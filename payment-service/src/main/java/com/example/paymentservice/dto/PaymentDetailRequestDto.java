package com.example.paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PaymentDetailRequestDto {

    @JsonProperty("payment_id")
    private String paymentId;
}

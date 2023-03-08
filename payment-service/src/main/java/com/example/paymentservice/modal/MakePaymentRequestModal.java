package com.example.paymentservice.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MakePaymentRequestModal {
    private String username;
    private Double amount;
    @JsonProperty("order_id")
    private String orderId;
}

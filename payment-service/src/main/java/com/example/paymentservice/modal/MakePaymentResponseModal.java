package com.example.paymentservice.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MakePaymentResponseModal {
    @JsonProperty("payment_id")
    private String paymentId;
}

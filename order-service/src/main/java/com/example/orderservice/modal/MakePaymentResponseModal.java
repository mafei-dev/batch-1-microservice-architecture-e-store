package com.example.orderservice.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MakePaymentResponseModal {
    @JsonProperty("payment_id")
    private String paymentId;
}

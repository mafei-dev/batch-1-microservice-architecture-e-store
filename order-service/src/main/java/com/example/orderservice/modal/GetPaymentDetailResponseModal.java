package com.example.orderservice.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentDetailResponseModal {
    @JsonProperty("payment_id")
    private Long paymentId;
    private Double amount;
    @JsonProperty("payment_status")
    private String paymentStatus;
    @JsonProperty("added_datetime")
    private LocalDateTime addedDatetime;
}

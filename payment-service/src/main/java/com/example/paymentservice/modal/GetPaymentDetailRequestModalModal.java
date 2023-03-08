package com.example.paymentservice.modal;

import com.example.paymentservice.entity.OrderPaymentEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
public class GetPaymentDetailRequestModalModal {

    @JsonProperty("payment_id")
    private Long paymentId;
    private Double amount;
    @JsonProperty("payment_status")
    private OrderPaymentEntity.PaymentStatus paymentStatus;
    @JsonProperty("added_datetime")
    private LocalDateTime addedDatetime;

}

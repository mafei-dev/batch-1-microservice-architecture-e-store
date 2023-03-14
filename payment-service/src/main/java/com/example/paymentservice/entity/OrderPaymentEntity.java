package com.example.paymentservice.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Table("order_payment_table")
public class OrderPaymentEntity {
    @Id
    private Long paymentId;
    private Double amount;
    private PaymentStatus paymentStatus;
    private LocalDateTime addDatetime;
    private String username;
    private String orderId;

    public enum PaymentStatus {
        SUCCESS,
        FAILED,
        PENDING,
    }
}

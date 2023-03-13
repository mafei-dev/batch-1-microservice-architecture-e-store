package com.example.orderservice.modal;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakeOrderRequestModal {
    private String username;
    private Double amount;
}

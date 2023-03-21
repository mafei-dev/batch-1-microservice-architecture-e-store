package com.example.orderservice.controller;

import com.example.orderservice.dto.PlaceOrderRequestDto;
import com.example.orderservice.dto.PlaceOrderResponseDto;
import com.example.orderservice.modal.MakeOrderRequestModal;
import com.example.orderservice.modal.MakeOrderResponseModal;
import com.example.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MakeOrderResponseModal makeOrder(@RequestBody MakeOrderRequestModal requestModal) {
        PlaceOrderResponseDto placeOrderResponseDto = this.orderService.makeOrder(
                PlaceOrderRequestDto.builder()
                        .amount(requestModal.getAmount())
                        .username(requestModal.getUsername())
                        .build()
        );
        return MakeOrderResponseModal.builder()
                .orderId(placeOrderResponseDto.getOrderId())
                .build();
    }


}

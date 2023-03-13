package com.example.orderservice.mapper;

import com.example.orderservice.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface OrderMapper {

    void save(OrderEntity orderEntity);

    Optional<OrderEntity> getOrderByOrderId(String orderId);

}

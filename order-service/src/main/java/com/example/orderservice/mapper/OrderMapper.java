package com.example.orderservice.mapper;

import com.example.orderservice.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface OrderMapper {

    void save(@Param("orderEntity") OrderEntity orderEntity);

    void updateTransactionData(String orderId, String transactionId);

    Optional<OrderEntity> getOrderByOrderId(String orderId);


}

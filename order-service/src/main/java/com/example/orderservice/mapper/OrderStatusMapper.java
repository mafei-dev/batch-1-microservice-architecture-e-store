package com.example.orderservice.mapper;

import com.example.orderservice.entity.OrderStatusEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderStatusMapper {

    void save(OrderStatusEntity orderStatusEntity);

    List<OrderStatusEntity> getStatus(String orderId);

}

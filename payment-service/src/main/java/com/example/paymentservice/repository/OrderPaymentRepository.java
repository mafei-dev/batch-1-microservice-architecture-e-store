package com.example.paymentservice.repository;

import com.example.paymentservice.entity.OrderPaymentEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPaymentRepository extends ReactiveCrudRepository<OrderPaymentEntity, Long> {

}

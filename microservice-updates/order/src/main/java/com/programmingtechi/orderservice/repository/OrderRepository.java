package com.programmingtechi.orderservice.repository;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;

import com.programmingtechi.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}

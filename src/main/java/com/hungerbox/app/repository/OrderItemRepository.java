package com.hungerbox.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hungerbox.app.entity.OrderItem;

public interface OrderItemRepository  extends JpaRepository<OrderItem, Integer>{

}

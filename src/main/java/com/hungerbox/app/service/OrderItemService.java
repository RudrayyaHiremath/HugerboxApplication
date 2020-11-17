package com.hungerbox.app.service;

import java.util.List;
import java.util.Optional;

import com.hungerbox.app.dto.OrderItemRequestDto;
import com.hungerbox.app.dto.OrderItemResponseDto;
import com.hungerbox.app.entity.OrderItem;

public interface OrderItemService {
	
	String addOrderItem(OrderItem orderItem);

	List<OrderItem> searchOrderItemByUserId(Integer userId);

	List<OrderItem> findByUserId(Integer userId);

}

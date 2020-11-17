package com.hungerbox.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungerbox.app.dto.OrderItemRequestDto;
import com.hungerbox.app.entity.OrderItem;
import com.hungerbox.app.repository.OrderItemRepository;
import com.hungerbox.app.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	OrderItemRepository orderItemRepository;

	@Override
	public String addOrderItem(OrderItem orderItem) {
		System.out.println("in addOrderItem OrderItemServiceImpl::" + orderItem);

		OrderItem newOrderItem = new OrderItem();
		//BeanUtils.copyProperties(newOrderItem, orderItem);
		System.out.println("userOrder:::" + orderItem);
		OrderItem savedOrderItem = orderItemRepository.save(orderItem);
		Optional<OrderItem> userUpdated = orderItemRepository.findById(savedOrderItem.getOrderItemId());
		String message = null;
		if (userUpdated.isPresent()) {
			message = "OrderItem Saved Successfully.";
		} else {
			message = "OrderItem Not Saved .";
		}
		return message;
	}

	@Override
	public List<OrderItem> searchOrderItemByUserId(Integer userId) {
		//orderItemRepository
		return null;
	}

	@Override
	public List<OrderItem> findByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}
}

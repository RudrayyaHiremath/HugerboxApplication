package com.hungerbox.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungerbox.app.dto.UserOrderRequestDto;
import com.hungerbox.app.dto.UserOrderResponseDto;
import com.hungerbox.app.entity.OrderItem;
import com.hungerbox.app.entity.User;
import com.hungerbox.app.entity.UserOrder;
import com.hungerbox.app.repository.UserOrderRepository;
import com.hungerbox.app.repository.UserRepository;
import com.hungerbox.app.service.UserOrderService;

@Service
public class UserOrderServiceImpl implements UserOrderService{

	@Autowired
	UserOrderRepository  userOrderRepository;
	
	@Autowired
	UserRepository  userRepository;
	
	
	@Override
	public List<UserOrderResponseDto> getUserOrderByuserId(Integer userId) {
		List<UserOrderResponseDto> userOrderResponseDto = new ArrayList<UserOrderResponseDto>();
		
		List<UserOrder> userOrder = userOrderRepository.serchUserOrderByUserId(userId);
		
		UserOrderResponseDto userOrderResponseDto1 = null;
		for(UserOrder userOrders : userOrder) {
			userOrderResponseDto1 = new UserOrderResponseDto();
			BeanUtils.copyProperties(userOrders, userOrderResponseDto1);
			userOrderResponseDto.add(userOrderResponseDto1);
		}
		
		System.out.println("userOrder::"+userOrder);
		BeanUtils.copyProperties(userOrder, userOrderResponseDto);
		System.out.println("userOrderResponseDto:::"+userOrderResponseDto);
		return  userOrderResponseDto;
	}
	
	
	@Override
	public String addUserOrder(UserOrderRequestDto userOrderRequestDto,Integer userId ) {
		System.out.println("in addUserOrder UserOrderServiceImpl::"+userOrderRequestDto);
		
		User user = userRepository.findById(userId).get();
		System.out.println("user::"+user);
		UserOrder userOrder = new UserOrder();
		Integer userId_1 = user.getUserId();
		
		//BeanUtils.copyProperties(userOrderRequestDto, userOrder);
		
		userOrder.setOrderDate(userOrderRequestDto.getOrderDate());
		userOrder.setOrderTotalPrice(userOrderRequestDto.getOrderTotalPrice());
		userOrder.setUser(userRepository.findById(userId).get());
		
		System.out.println("userOrder:::" + userOrder);
		UserOrder savedUserOrder = userOrderRepository.save(userOrder);
		Optional<UserOrder> userUpdated = userOrderRepository.findById(savedUserOrder.getOrderId());
		String message = null;
		if (userUpdated.isPresent()) {
			message = "UserOrder Saved Successfully.";
		} else {
			message = "UserOrder Not Saved .";
		}
		return message;
		
	}

	@Override
	public UserOrder getUserOrder(Integer orderId) {
		System.out.println("getUserOrder() in serviceimpl...");
		return userOrderRepository.findById(orderId).get();
	}
	
	@Override
	public List<UserOrder> getUserOrders() {
		
		System.out.println("getUserOrders() in serviceimpl...");
		
		List<UserOrder> userOrderList = userOrderRepository.findAll();
		
		for (UserOrder userOrder : userOrderList) {
			List<OrderItem> orderItem= userOrder.getOrderItems();
			for (OrderItem orderItem2 : orderItem) {
				Integer quantity = orderItem2.getQuantity();
					System.out.println("quantity::"+quantity);
					Double total_price = 0.0;
					for (int i = 0; i < quantity; i++) {
						System.out.println("in for loop::"+userOrder.getOrderTotalPrice());
						total_price = total_price + userOrder.getOrderTotalPrice();
						System.out.println("total_price::"+total_price);
						userOrder.setOrderTotalPrice(total_price);
					}
			}
		}
		return userOrderList;
	}

	
}

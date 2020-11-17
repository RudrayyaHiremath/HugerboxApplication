package com.hungerbox.app.service;

import java.util.List;

import com.hungerbox.app.dto.UserOrderRequestDto;
import com.hungerbox.app.dto.UserOrderResponseDto;
import com.hungerbox.app.entity.UserOrder;

public interface UserOrderService {

	String addUserOrder(UserOrderRequestDto userOrderRequestDto, Integer userId );

	//List<UserOrderResponseDto> getAllUserOrder();
	
	UserOrder getUserOrder(Integer userOrderId);
	
	List<UserOrder> getUserOrders();

	List<UserOrderResponseDto> getUserOrderByuserId(Integer userId);

}

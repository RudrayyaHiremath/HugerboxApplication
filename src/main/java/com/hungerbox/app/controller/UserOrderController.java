package com.hungerbox.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hungerbox.app.dto.UserOrderRequestDto;
import com.hungerbox.app.dto.UserOrderResponseDto;
import com.hungerbox.app.entity.UserOrder;
import com.hungerbox.app.service.UserOrderService;

@RestController
public class UserOrderController {
	
	@Autowired
	UserOrderService userOrderService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserOrderController.class);
	
	@GetMapping("/getUserOrderByuserId/{userId}")
	public ResponseEntity<List<UserOrderResponseDto>> getUserOrderByuserId(@PathVariable("userId") Integer userId){
		LOGGER.info("getUserOrderByuserId..............");
		return new ResponseEntity<List<UserOrderResponseDto>>(userOrderService.getUserOrderByuserId(userId),HttpStatus.OK);
	}
	
	
	@PostMapping("/userOrder/{userId}")
	public ResponseEntity<String> addUserOrder(@PathVariable("userId") Integer userId, @RequestBody UserOrderRequestDto userOrderRequestDto)  {
		
		LOGGER.info("addUser in controller ...userOrderRequestDto:::"+userOrderRequestDto);
		
		return new ResponseEntity<String>(userOrderService.addUserOrder(userOrderRequestDto, userId),HttpStatus.CREATED);
	}
	
	@GetMapping("/getUserOrder/{orderId}")
	public ResponseEntity<UserOrder> getUserOrder(@PathVariable("orderId") Integer orderId){
		LOGGER.info("getUserOrder..............");
		return new ResponseEntity<UserOrder>(userOrderService.getUserOrder(orderId),HttpStatus.OK);
	}
	
	
	@GetMapping("/getUserOrders")
	public ResponseEntity<List<UserOrder>> getUserOrders(){
		LOGGER.info("getUserOrders.....all.........");
		return new ResponseEntity<List<UserOrder>>(userOrderService.getUserOrders(),HttpStatus.OK);
	}
	
}

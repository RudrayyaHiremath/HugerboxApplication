package com.hungerbox.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hungerbox.app.entity.OrderItem;
import com.hungerbox.app.service.OrderItemService;

@RestController
public class OrderItemController {

	@Autowired
	OrderItemService orderItemService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderItemController.class);
	@PostMapping("/addOrderItem")
	public ResponseEntity<String> addOrderItem(@RequestBody OrderItem orderItem) {

		LOGGER.info("addOrderItem in controller ...orderItem:::" + orderItem);

		return new ResponseEntity<String>(orderItemService.addOrderItem(orderItem), HttpStatus.CREATED);
	}
	
	
	
	
	@GetMapping("/searchOrderItemByUserId")
	public List<OrderItem> searchOrderItemByUserId(@RequestParam Integer userId) {
		return orderItemService.searchOrderItemByUserId(userId);

	}
	
	@GetMapping("/searchOrderByUserId")
	public List<OrderItem> getOrdersById(@RequestParam Integer userId) {
		return orderItemService.findByUserId(userId);

	}
}

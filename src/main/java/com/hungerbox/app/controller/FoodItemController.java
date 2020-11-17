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

import com.hungerbox.app.dto.FoodItemRequestDto;
import com.hungerbox.app.dto.FoodItemResponseDto;
import com.hungerbox.app.exception.FoodItemNotFoundException;
import com.hungerbox.app.service.FoodItemService;


@RestController
public class FoodItemController {
	
	@Autowired
	FoodItemService foodItemService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FoodItemController.class);
	@GetMapping("/foodItem")
	public ResponseEntity<List<FoodItemResponseDto>> findByitemName(@RequestParam("itemName") String itemName)throws FoodItemNotFoundException {
		LOGGER.info("findByitemName........in controller.......");
		List<FoodItemResponseDto> itemLists = foodItemService.findByitemName(itemName);
		return new ResponseEntity<List<FoodItemResponseDto>> (itemLists, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/foodItem")
	public ResponseEntity<String> createItem(@RequestBody FoodItemRequestDto foodItemRequestDto) throws FoodItemNotFoundException {
		LOGGER.info("createItem.............");
		String items = foodItemService.createItem(foodItemRequestDto);
		return new ResponseEntity<String>(items, HttpStatus.ACCEPTED);
	}

}

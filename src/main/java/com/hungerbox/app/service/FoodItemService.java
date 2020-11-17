package com.hungerbox.app.service;


import java.util.List;

import com.hungerbox.app.dto.FoodItemRequestDto;
import com.hungerbox.app.dto.FoodItemResponseDto;
import com.hungerbox.app.exception.FoodItemNotFoundException;

public interface FoodItemService {


	String createItem(FoodItemRequestDto foodItemRequestDto) throws FoodItemNotFoundException;

	List<FoodItemResponseDto> findByitemName(String itemName);
	
	FoodItemResponseDto getItem(Integer itemId);

}

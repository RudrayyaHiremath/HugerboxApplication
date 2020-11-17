package com.hungerbox.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungerbox.app.dto.FoodItemRequestDto;
import com.hungerbox.app.dto.FoodItemResponseDto;
import com.hungerbox.app.entity.FoodItem;
import com.hungerbox.app.exception.FoodItemNotFoundException;
import com.hungerbox.app.repository.FoodItemRepository;
import com.hungerbox.app.service.FoodItemService;

@Service
public class FoodItemServiceImpl implements FoodItemService{
	
	@Autowired
	FoodItemRepository foodItemRepository;
		
	@Override
	public List<FoodItemResponseDto> findByitemName(String itemName) {
		System.out.println("findByitemName in service............"+itemName);
		List<FoodItem> foodItem = foodItemRepository.findByItemNameContains(itemName);
		
		System.out.println("foodItem::"+foodItem);
		List<FoodItemResponseDto> foodItemResponseDto= new ArrayList<>();
		
		FoodItemResponseDto foodItemResponseDto1 = null;
		
		for(FoodItem foodItems : foodItem) {
			foodItemResponseDto1 = new FoodItemResponseDto();
			
			foodItemResponseDto1.setItemId(foodItems.getItemId());
			
			foodItemResponseDto1.setItemName(foodItems.getItemName());
			
			foodItemResponseDto1.setItemDescription(foodItems.getItemDescription());
			
			foodItemResponseDto1.setItemPrice(foodItems.getItemPrice());
			
			foodItemResponseDto1.setVenderId(foodItems.getVender().getVenderId());
			
			//BeanUtils.copyProperties(foodItems, foodItemResponseDto1);
			
			foodItemResponseDto.add(foodItemResponseDto1);
		}
		System.out.println("foodItemResponseDto::"+foodItemResponseDto);
		return foodItemResponseDto;
	}

	@Override
	public FoodItemResponseDto getItem(Integer itemId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public String createItem(FoodItemRequestDto foodItemRequestDto) throws FoodItemNotFoundException{
		System.out.println("createCourse..........serviceimpl.....");
		System.out.println("newUser:::" + foodItemRequestDto);
		FoodItem foodItem = new FoodItem();
		BeanUtils.copyProperties(foodItemRequestDto, foodItem);
		System.out.println("foodItem:::" + foodItem);
		FoodItem savedFoodItemr = foodItemRepository.save(foodItem);
		Optional<FoodItem> userUpdated = foodItemRepository.findById(savedFoodItemr.getItemId());
		String message = null;
		if (userUpdated.isPresent()) {
			message = "FoodItem Saved Successfully.";
		} else {
			message = "FoodItem Not Saved .";
		}
		return message;
	    }
	
}

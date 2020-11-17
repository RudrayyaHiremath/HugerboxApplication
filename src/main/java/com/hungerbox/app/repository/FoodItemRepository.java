package com.hungerbox.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hungerbox.app.dto.FoodItemResponseDto;
import com.hungerbox.app.entity.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Integer>{

	List<FoodItemResponseDto> findByVenderVenderId(Integer venderId);

	
	List<FoodItem> findByItemNameContains(String itemName);

}

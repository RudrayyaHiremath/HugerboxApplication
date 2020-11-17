package com.hungerbox.app.dto;


public class FoodItemRequestDto {

	private Integer itemId;

	private String itemName;

	private String itemDescription;

	private Double itemPrice;
	
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	/*
	 * public Vender getVender() { return vender; }
	 * 
	 * public void setVender(Vender vender) { this.vender = vender; }
	 */
	@Override
	public String toString() {
		return "FoodItemRequestDto [itemId=" + itemId + ", itemName=" + itemName + ", itemDescription="
				+ itemDescription + ", itemPrice=" + itemPrice +  "]";
	}

	
	
	
	
	
}

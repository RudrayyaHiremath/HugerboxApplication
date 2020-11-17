package com.hungerbox.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.hungerbox.app.entity.FoodItem;

public class VenderResponseDto {

	private Integer venderId;

	private String venderName;

	private String venderDescription;

	private String venderAddress;

	private String venderPhoneNumber;

	private String venderEmail;

	private List<FoodItem> items = new ArrayList<>();

	public Integer getVenderId() {
		return venderId;
	}

	public void setVenderId(Integer venderId) {
		this.venderId = venderId;
	}

	public String getVenderName() {
		return venderName;
	}

	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}

	public String getVenderDescription() {
		return venderDescription;
	}

	public void setVenderDescription(String venderDescription) {
		this.venderDescription = venderDescription;
	}

	public String getVenderAddress() {
		return venderAddress;
	}

	public void setVenderAddress(String venderAddress) {
		this.venderAddress = venderAddress;
	}

	public String getVenderPhoneNumber() {
		return venderPhoneNumber;
	}

	public void setVenderPhoneNumber(String venderPhoneNumber) {
		this.venderPhoneNumber = venderPhoneNumber;
	}

	public String getVenderEmail() {
		return venderEmail;
	}

	public void setVenderEmail(String venderEmail) {
		this.venderEmail = venderEmail;
	}

	public List<FoodItem> getItems() {
		return items;
	}

	public void setItems(List<FoodItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "VenderResponseDto [venderId=" + venderId + ", venderName=" + venderName + ", venderDescription="
				+ venderDescription + ", venderAddress=" + venderAddress + ", venderPhoneNumber=" + venderPhoneNumber
				+ ", venderEmail=" + venderEmail + ", items=" + items + "]";
	}

	
	
	
}

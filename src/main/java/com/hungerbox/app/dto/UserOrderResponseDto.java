package com.hungerbox.app.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserOrderResponseDto {

private Integer orderId;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date orderDate;

	private Double orderTotalPrice;

	//private Integer userId;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Double getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(Double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	/*
	 * public Integer getUserId() { return userId; }
	 * 
	 * public void setUserId(Integer userId) { this.userId = userId; }
	 */

	@Override
	public String toString() {
		return "UserOrderResponseDto [orderId=" + orderId + ", orderDate=" + orderDate + ", orderTotalPrice="
				+ orderTotalPrice + "]";
	}
	
	
}

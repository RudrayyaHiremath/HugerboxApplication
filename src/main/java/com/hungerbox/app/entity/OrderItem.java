package com.hungerbox.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "Order_Item")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_item_id")
	private Integer OrderItemId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_order_id")
	@JsonBackReference
	private UserOrder userOrder;
	
	@OneToMany( cascade = CascadeType.ALL)	
	private List<FoodItem> foodItems  = new ArrayList<>();
	
	private Integer quantity;

	public Integer getOrderItemId() {
		return OrderItemId;
	}

	public void setOrderItem(Integer orderItemId) {
		OrderItemId = orderItemId;
	}

	

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	

}

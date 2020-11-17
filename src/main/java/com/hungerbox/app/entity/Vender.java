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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="VENDER")
public class Vender implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vender_id")
	private Integer venderId;
	
	@Column(name = "vender_name")
	private String venderName;
	
	@Column(name = "vender_description")
	private String venderDescription;
	
	@Column(name = "vender_address")
	private String venderAddress;
	
	@Column(name = "vender_phonenumber")
	private String venderPhoneNumber;
	
	@Column(name = "vender_email")
	private String venderEmail;
	
	@OneToMany(mappedBy = "vender",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<FoodItem> foodItems = new ArrayList<>();

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
		return foodItems;
	}

	public void setItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}
	
	
	
}

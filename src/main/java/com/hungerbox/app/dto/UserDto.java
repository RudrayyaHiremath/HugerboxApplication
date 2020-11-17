package com.hungerbox.app.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserDto {

	
	@NotNull(message="User Id is mandatory")
	private Integer userId;
	@NotNull
	@NotBlank(message="Please enter firstname")
	private String firstName;
	@NotNull
	@NotBlank(message="Please enter firstname")
	private String lastName;

	private String phoneNumber;
	
	@NotBlank(message = "Email is mandatory")
	private String email;
	@NotNull
	@NotBlank(message="Please enter username")
	private String userName;
	
	//@Pattern(regexp="^[a-zA-Z0-9]{3}",message="length must be 3")  
	private String password;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
	
}

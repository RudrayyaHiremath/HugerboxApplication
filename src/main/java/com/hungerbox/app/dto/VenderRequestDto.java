package com.hungerbox.app.dto;


public class VenderRequestDto {

	private Integer venderId;

	private String venderName;

	private String venderDescription;

	private String venderAddress;

	private String venderPhoneNumber;

	private String venderEmail;

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

	@Override
	public String toString() {
		return "VenderRequestDto [venderId=" + venderId + ", venderName=" + venderName + ", venderDescription="
				+ venderDescription + ", venderAddress=" + venderAddress + ", venderPhoneNumber=" + venderPhoneNumber
				+ ", venderEmail=" + venderEmail + "]";
	}

	

	
	
}

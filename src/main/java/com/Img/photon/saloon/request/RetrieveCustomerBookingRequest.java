package com.Img.photon.saloon.request;


import com.fasterxml.jackson.annotation.JsonProperty;

public class RetrieveCustomerBookingRequest {
	@JsonProperty("mobile_number")
	private String mobileNumber;
	
	@JsonProperty("email_address")
	private String emailAddress;
	
	@JsonProperty("page_number")
	private int pageNumber;
	
	@JsonProperty("page_size")
	private int size;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	

}

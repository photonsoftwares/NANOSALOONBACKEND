package com.Img.photon.saloon.response;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Data;

@Data
public class RetailSignUpResponse {

	
	@JsonProperty("mobile_number")
	private String mobileNumber;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("store_id")
	private String storeId;
	
	@JsonProperty("store_name")
	private String storeName;

	@JsonProperty("hsn_code")
	private String hsnCode;

	@JsonProperty("gst_code")
	private String gstCode;
	
	@JsonProperty("logo")
	private String logo;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("state")
	private String state;

	@JsonProperty("country")
	private String country;	
	
	
}
package com.Img.photon.saloon.response;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Data;

@Data
public class CustomerSignUpResponse {

	@JsonProperty("mobile_number")
	private String mobileNumber;

	@JsonProperty("password")
	private String password;
	
	@JsonProperty("customer_name")
	private String customerName;
	
	@JsonProperty("store_name")
	private String storeName;
	
	@JsonProperty("delivery_address")
	private String deliveryAddress;
	
	@JsonProperty("email")
	private String email;

	@JsonProperty("store_id")
	private String storeId;
	
	@JsonProperty("saas_id")
	private String saasId;
	
}

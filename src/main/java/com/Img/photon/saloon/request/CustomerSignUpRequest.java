package com.Img.photon.saloon.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CustomerSignUpRequest {

	@JsonProperty("user_name")
	private String userName;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("store_id")
	private String storeId;
	
	@JsonProperty("saas_id")
	private String saasId;
	
	@JsonProperty("mobile_number")
	private String mobileNumber;

	@JsonProperty("email")
	private String email;
	
	@JsonProperty("status")
	private Boolean status;

	
	
	

	
	
	
}

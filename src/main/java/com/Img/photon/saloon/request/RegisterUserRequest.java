package com.Img.photon.saloon.request;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RegisterUserRequest {
	
	@JsonProperty("user_name")
	private String userName;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("store_name")
	private String storeName;
	
	@JsonProperty("store_id")
	private String storeId;
	
	@JsonProperty("saas_id")
	private String saasId;
	
	@JsonProperty("register_id")
	private String registerId;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("special_price")
	private String specialPrice;

	@JsonProperty("category_name")
	private String categoryName;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("brand_logo")
	private String brandLogo;
	
	@JsonProperty("taxable")
	private boolean taxable;
	
	@JsonProperty("gst_code")
	private String gstCode;
	
	@JsonProperty("hsn_code")
	private String hsnCode;
	
	@JsonProperty("store_type")
	private String storeType;
	
	@JsonProperty("address")
	private String address;
}



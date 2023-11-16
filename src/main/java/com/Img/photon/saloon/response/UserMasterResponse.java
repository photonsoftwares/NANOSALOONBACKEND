package com.Img.photon.saloon.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserMasterResponse {
	
	@JsonProperty("user_name")
	private String userName;
	
	@JsonProperty("mobile_number")
	private String mobileNumber;
	
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
	
	@JsonProperty("base_currency")
	private String baseCurrencty;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("country")
	private String country;
	@JsonProperty("baar_code")
	private String baarCode;
	@JsonProperty("category_req")
	private String categoryReq;

	@JsonProperty("status")
	private Boolean status;

	@JsonProperty("created_at")
	private LocalDateTime createdAt;
	
	@JsonProperty("expiration")
	private LocalDate expiration;

}

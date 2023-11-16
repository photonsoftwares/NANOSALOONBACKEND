package com.Img.photon.saloon.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Data;

@Data
public class CustomerProfileResponse {
	
	
	@JsonProperty("customer_id")
	private long id;
	
	
	@JsonProperty("mobile_number")
	private String mobileNumber;

	@JsonProperty("email")
	private String email;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("address_1")
	private String address1;
	
	@JsonProperty("address_2")
	private String address2;

	@JsonProperty("address_3")
	private String address3;
	
	@JsonProperty("source_of_acq")
	private String sourceOfAcquisition;
	
	@JsonProperty("dob")
	private LocalDate dob;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("occupation")
	private String occupation;
	
	@JsonProperty("discount_percent")
	private BigDecimal discountPercent;
	
	@JsonProperty("customer_type")
	private String customerType;
	
	@JsonProperty("income_level")
	private BigDecimal incomeLevel;
	
	@JsonProperty("saas_id")
	private String saasId;
	
	@JsonProperty("store_id")
	private String storeId;
	
	@JsonProperty("created_at")
	private LocalDateTime createdAt;
}


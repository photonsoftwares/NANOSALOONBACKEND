package com.Img.photon.saloon.response;

import java.util.List;

import com.Img.photon.saloon.model.Customer;
import com.Img.photon.saloon.model.StoreMaster;
import com.Img.photon.saloon.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserAuthResponse {

	@JsonProperty("user_data")
	private User userData;
	
	@JsonProperty("store_data")
	private StoreMaster storeData;
	
	@JsonProperty("customer_data")
	private Customer customerData;
	
	@JsonProperty("store_name")
	private String storeName;
	
	@JsonProperty("store_logo")
	private String storeLogo;
	
	@JsonProperty("address_data")
	private List<Long> addressData;
	
	@JsonProperty("jwt_response")
	private String jwtResponse;
	
}
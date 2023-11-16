package com.Img.photon.saloon.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserResponse {

	@JsonProperty("user_id")
	private Long userId;
	@JsonProperty("user_name")
    private String userName;
	@JsonProperty("store_id")
    private String storeId;
	@JsonProperty("saas_id")
    private String saasId;
	@JsonProperty("register_id")
    private String registerId;
	@JsonProperty("status")
    private Boolean status;
	@JsonProperty("baar_code")
	private String baarCode;
	@JsonProperty("category_req")
	private String categoryReq;
	
	
}
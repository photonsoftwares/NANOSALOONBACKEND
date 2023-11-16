package com.Img.photon.saloon.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserLoginRequest {
	
	@JsonProperty("user_name")
	private String userName;
	
	@JsonProperty("password")
	private String password;
	
}

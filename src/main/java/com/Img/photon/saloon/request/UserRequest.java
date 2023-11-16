package com.Img.photon.saloon.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserRequest {

		@JsonProperty("user_name")
		private String userName;
		
		@JsonProperty("password")
	    private String password;
}

package com.Img.photon.saloon.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OtpRequest {

	@JsonProperty("mobile_no")
	private String mobileNo;
	
	@JsonProperty("otp")
	private Long otp;
	

}

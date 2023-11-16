package com.Img.photon.saloon.response;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Data;

@Data
public class OtpResponse extends BaseResponse {

	@JsonProperty("otp")
	private Long otp;
	

	
	
}

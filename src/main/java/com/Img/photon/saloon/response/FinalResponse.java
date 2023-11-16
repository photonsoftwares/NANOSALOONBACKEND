package com.Img.photon.saloon.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FinalResponse {
	
	@JsonProperty("status")
	private boolean status;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("data")
	private Object data;

}

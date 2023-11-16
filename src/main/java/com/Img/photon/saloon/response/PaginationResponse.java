package com.Img.photon.saloon.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PaginationResponse {

	
	@JsonProperty("count")
	private int count;

	@JsonProperty("status")
	private boolean status;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("data")
	private Object data;
	
	@JsonProperty("prev")
	private Integer prev;
	
	@JsonProperty("next")
	private Integer next;
	
}

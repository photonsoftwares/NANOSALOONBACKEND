package com.Img.photon.saloon.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class StoreNameResponse {

	@JsonProperty("store_name")
	private String storeName;
}

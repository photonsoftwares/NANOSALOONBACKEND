package com.Img.photon.saloon.request;


import com.fasterxml.jackson.annotation.JsonProperty;

public class StoreAssistantUpdateRequest  {	
	
	@JsonProperty("store_id")
	private String storeId;
	
	@JsonProperty("store_manager")
	private String storeManager;
	
	@JsonProperty("store_assistant_email")
	private String storeAssistantEmail;
	
	@JsonProperty("store_assistant_mobile")
	private String storeAssistantMobile;
	
	@JsonProperty("preffered_language")
	private String preferredLanguage;

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreManager() {
		return storeManager;
	}

	public void setStoreManager(String storeManager) {
		this.storeManager = storeManager;
	}
	
	public String getPreferredLanguage() {
		return preferredLanguage;
	}

	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}

	/**
	 * @return the storeAssistantEmail
	 */
	public String getStoreAssistantEmail() {
		return storeAssistantEmail;
	}

	/**
	 * @param storeAssistantEmail the storeAssistantEmail to set
	 */
	public void setStoreAssistantEmail(String storeAssistantEmail) {
		this.storeAssistantEmail = storeAssistantEmail;
	}

	/**
	 * @return the storeAssistantMobile
	 */
	public String getStoreAssistantMobile() {
		return storeAssistantMobile;
	}

	/**
	 * @param storeAssistantMobile the storeAssistantMobile to set
	 */
	public void setStoreAssistantMobile(String storeAssistantMobile) {
		this.storeAssistantMobile = storeAssistantMobile;
	}
	
	
	
}

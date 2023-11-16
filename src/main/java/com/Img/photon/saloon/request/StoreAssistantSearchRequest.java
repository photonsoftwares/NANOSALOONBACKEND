package com.Img.photon.saloon.request;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StoreAssistantSearchRequest  {

	@JsonProperty("store_id")
	private String storeId;

	@JsonProperty("assistant_id")
	private String assistantId;

	@JsonProperty("assistant_name")
	private String assistantName;

	@JsonProperty("preferred_dates")
	private List<String> preferredDates;

	@JsonProperty("locale")
	private String locale;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("slot_duration")
	private int slotDuration;

	@JsonProperty("report")
	private boolean report;

	@JsonProperty("role")
	private String role;

	/**
	 * @return the storeId
	 */
	public String getStoreId() {
		return storeId;
	}

	/**
	 * @param storeId the storeId to set
	 */
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	/**
	 * @return the assistantId
	 */
	public String getAssistantId() {
		return assistantId;
	}

	/**
	 * @param assistantId the assistantId to set
	 */
	public void setAssistantId(String assistantId) {
		this.assistantId = assistantId;
	}

	/**
	 * @return the assistantName
	 */
	public String getAssistantName() {
		return assistantName;
	}

	/**
	 * @param assistantName the assistantName to set
	 */
	public void setAssistantName(String assistantName) {
		this.assistantName = assistantName;
	}

	/**
	 * @return the preferredDates
	 */
	public List<String> getPreferredDates() {
		return preferredDates;
	}

	/**
	 * @param preferredDates the preferredDates to set
	 */
	public void setPreferredDates(List<String> preferredDates) {
		this.preferredDates = preferredDates;
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the slotDuration
	 */
	public int getSlotDuration() {
		return slotDuration;
	}

	/**
	 * @param slotDuration the slotDuration to set
	 */
	public void setSlotDuration(int slotDuration) {
		this.slotDuration = slotDuration;
	}

	/**
	 * @return the report
	 */
	public boolean isReport() {
		return report;
	}

	/**
	 * @param report the report to set
	 */
	public void setReport(boolean report) {
		this.report = report;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

}

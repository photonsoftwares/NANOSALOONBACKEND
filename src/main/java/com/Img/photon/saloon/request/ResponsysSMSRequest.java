package com.Img.photon.saloon.request;

import java.time.LocalDate;
import java.util.List;

public class ResponsysSMSRequest {

	
	private MergeTriggerRecordData mergeTriggerRecordData;
	private MergeRule mergeRule;
	private String requestType= null;
	

	

public static class MergeRule{
	private String 	htmlValue;
	private String matchColumnName1;
	private String matchColumnName2;
	private String optoutValue;
	private String optinValue;
	private Boolean insertOnNoMatch;
	private String defaultPermissionStatus;
	private String rejectRecordIfChannelEmpty;
	private String updateOnMatch;
	private String textValue;
	private String matchOperator;
	public String getHtmlValue() {
		return htmlValue;
	}
	public void setHtmlValue(String htmlValue) {
		this.htmlValue = htmlValue;
	}
	public String getMatchColumnName1() {
		return matchColumnName1;
	}
	public void setMatchColumnName1(String matchColumnName1) {
		this.matchColumnName1 = matchColumnName1;
	}
	public String getMatchColumnName2() {
		return matchColumnName2;
	}
	public void setMatchColumnName2(String matchColumnName2) {
		this.matchColumnName2 = matchColumnName2;
	}
	public String getOptoutValue() {
		return optoutValue;
	}
	public void setOptoutValue(String optoutValue) {
		this.optoutValue = optoutValue;
	}
	public String getOptinValue() {
		return optinValue;
	}
	public void setOptinValue(String optinValue) {
		this.optinValue = optinValue;
	}
	public Boolean getInsertOnNoMatch() {
		return insertOnNoMatch;
	}
	public void setInsertOnNoMatch(Boolean insertOnNoMatch) {
		this.insertOnNoMatch = insertOnNoMatch;
	}
	public String getDefaultPermissionStatus() {
		return defaultPermissionStatus;
	}
	public void setDefaultPermissionStatus(String defaultPermissionStatus) {
		this.defaultPermissionStatus = defaultPermissionStatus;
	}
	public String getRejectRecordIfChannelEmpty() {
		return rejectRecordIfChannelEmpty;
	}
	public void setRejectRecordIfChannelEmpty(String rejectRecordIfChannelEmpty) {
		this.rejectRecordIfChannelEmpty = rejectRecordIfChannelEmpty;
	}
	public String getUpdateOnMatch() {
		return updateOnMatch;
	}
	public void setUpdateOnMatch(String updateOnMatch) {
		this.updateOnMatch = updateOnMatch;
	}
	public String getTextValue() {
		return textValue;
	}
	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}
	public String getMatchOperator() {
		return matchOperator;
	}
	public void setMatchOperator(String matchOperator) {
		this.matchOperator = matchOperator;
	}
}

	public static class CustomEvent {
		private String eventStringDataMapping;
		private LocalDate eventDateDataMapping;
		private Number eventNumberDataMapping;
		public String getEventStringDataMapping() {
			return eventStringDataMapping;
		}
		public void setEventStringDataMapping(String eventStringDataMapping) {
			this.eventStringDataMapping = eventStringDataMapping;
		}
		public LocalDate getEventDateDataMapping() {
			return eventDateDataMapping;
		}
		public void setEventDateDataMapping(LocalDate eventDateDataMapping) {
			this.eventDateDataMapping = eventDateDataMapping;
		}
		public Number getEventNumberDataMapping() {
			return eventNumberDataMapping;
		}
		public void setEventNumberDataMapping(Number eventNumberDataMapping) {
			this.eventNumberDataMapping = eventNumberDataMapping;
		}
	}
	
	public static class MergeTriggerRecordData {
		private List<String> fieldNames;
		private List<MergeTriggerRecords> mergeTriggerRecords;
		public List<String> getFieldNames() {
			return fieldNames;
		}
		public void setFieldNames(List<String> fieldNames) {
			this.fieldNames = fieldNames;
		}
		public List<MergeTriggerRecords> getMergeTriggerRecords() {
			return mergeTriggerRecords;
		}
		public void setMergeTriggerRecords(List<MergeTriggerRecords> mergeTriggerRecords) {
			this.mergeTriggerRecords = mergeTriggerRecords;
		}
		
		
		
		
		
		
	}
	public static class MergeTriggerRecords {
		
		private List<OptionalDatum> optionalData;
		private List<String> fieldValues; 
		
		public List<OptionalDatum> getOptionalData() {
			return optionalData;
		}
		public void setOptionalData(List<OptionalDatum> optionalData) {
			this.optionalData = optionalData;
		}
		public List<String> getFieldValues() {
			return fieldValues;
		}
		public void setFieldValues(List<String> fieldValues) {
			this.fieldValues = fieldValues;
		}	
		
	}
	
	public static class Recipient {
		private String emailAddress;
		private String mobileNumber;
		private String recipientId;
		private ListName listName;
		private String emailFormat;
		public String getEmailAddress() {
			return emailAddress;
		}
		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}
		public String getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		public String getRecipientId() {
			return recipientId;
		}
		public void setRecipientId(String recipientId) {
			this.recipientId = recipientId;
		}
		public ListName getListName() {
			return listName;
		}
		public void setListName(ListName listName) {
			this.listName = listName;
		}
		public String getEmailFormat() {
			return emailFormat;
		}
		public void setEmailFormat(String emailFormat) {
			this.emailFormat = emailFormat;
		}	
		
	}
	
	public static class ListName {
		private String objectName;
		private String folderName;
		public String getObjectName() {
			return objectName;
		}
		public void setObjectName(String objectName) {
			this.objectName = objectName;
		}
		public String getFolderName() {
			return folderName;
		}
		public void setFolderName(String folderName) {
			this.folderName = folderName;
		}
		
	}
	
	public static class OptionalDatum {
		private String name;
		private String value;

		public OptionalDatum(String name, String value) {
			super();
			this.name = name;
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String value) {
			this.name = value;
		}
	}

	public MergeRule getMergeRule() {
		return mergeRule;
	}

	public void setMergeRule(MergeRule mergeRule) {
		this.mergeRule = mergeRule;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public MergeTriggerRecordData getMergeTriggerRecordData() {
		return mergeTriggerRecordData;
	}

	public void setMergeTriggerRecordData(MergeTriggerRecordData mergeTriggerRecordData) {
		this.mergeTriggerRecordData = mergeTriggerRecordData;
	}

	@Override
	public String toString() {
		return "ResponsysSMSRequest [mergeTriggerRecordData=" + mergeTriggerRecordData + ", mergeRule=" + mergeRule
				+ ", requestType=" + requestType + "]";
	}
	
}


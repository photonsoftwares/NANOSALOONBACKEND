package com.Img.photon.saloon.request;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponsysRequest {
	@JsonProperty("mergeTriggerRecordData")
	private MergeTriggerRecords mergeTriggerRecords;
}
 class MergeTriggerRecords{
	 @JsonProperty("mergeTriggerRecordData")
		private String shukranId;
}


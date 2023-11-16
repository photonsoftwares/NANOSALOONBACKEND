package com.Img.photon.saloon.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="SAAS_MASTER")
public class SaasMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	@Column(name="SAAS_ID")
	private String saasId;
	
	@Column(name="SAAS_NAME")
	private String saasName;
	
	@Column(name="STATUS")
	private Boolean status;
	
	@Column(name="START_DATE")
	private LocalDate startDate;
	
	@Column(name="BRAND_LOGO")
	private String brandLogo;
	
	@Column(name="CURRENCY")
	private String currency;
	
	@Column(name="END_DATE")
	private LocalDate endDate;
}

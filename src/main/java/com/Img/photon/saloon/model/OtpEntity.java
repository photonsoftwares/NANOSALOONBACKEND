package com.Img.photon.saloon.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Data
@Table(name="otp_master")
public class OtpEntity {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 
	 @Column(name = "mobile_no", nullable = false)
	 private String mobileNo;

	 @Column(name = "created_date", nullable = false)
	 private LocalDateTime createdDate;
	  
	 @Column(name = "otp", nullable = false)
	 private Long otp;
	 
	 @Column(name = "is_Validated", columnDefinition = "boolean default false")
	 private boolean isValidated;
	 
}
package com.Img.photon.saloon.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="CUSTOMER_MASTER")
public class Customer {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	@Column(name = "MOBILE_NUMBER", columnDefinition = "VARCHAR(25) NOT NULL", unique=true)
	private String mobileNumber;

	@Column(name = "EMAIL", columnDefinition = "VARCHAR(25)")
	private String email;
	
	@Column(name = "NAME", columnDefinition = "VARCHAR(25)")
	private String name;
	
	@Column(name = "PASSWORD", columnDefinition = "VARCHAR(25)")
	private String password;
	
	@Column(name = "SAAS_ID", columnDefinition = "VARCHAR(25)")
	private String saasId;

	@Column(name = "STORE_ID", columnDefinition = "VARCHAR(25)")
	private String storeId;
	
    @Column(name = "status")
    private Boolean status;
    
 

 
}
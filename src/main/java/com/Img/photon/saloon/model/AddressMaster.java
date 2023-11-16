package com.Img.photon.saloon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name="address_master")
@Data
public class AddressMaster {

	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
		
	 @Column(name = "address", columnDefinition = "TEXT")
		private String address;

	 @Column(name = "street", columnDefinition = "TEXT")
	 private String street;
	 
	 @Column(name = "pincode", columnDefinition = "Varchar(10)")
	  private String pincode;

	 @Column(name = "city", columnDefinition = "Varchar(20)")
	  private String city;

	 @Column(name = "state", columnDefinition = "Varchar(20)")
	  private String state;

	 @Column(name = "status", columnDefinition = "Varchar(10)")
	 private String status;
	 
	 @Column(name = "customer_id")
	  private long customerId;
	 
	 @Column(name = "store_id", columnDefinition = "Varchar(25)")
	 private String storeId;

	 @Column(name = "saas_id", columnDefinition = "Varchar(25)")
	  private String saasId;
	 
	 @Column(name = "address_type", columnDefinition = "Varchar(10)")
	  private String addressType;

}

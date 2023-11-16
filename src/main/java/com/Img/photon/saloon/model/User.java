package com.Img.photon.saloon.model;



import java.time.LocalDate;


import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="USER_MASTER")
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)	
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;
        
    @Column(name = "mobile_number", columnDefinition = "varchar(11)")
    private String mobileNumber;
    
	 @Column(name = "ADD_PAYMENT_REFERENCE", columnDefinition = "varchar(40)")
	 private String addedPaymentReference;
    
    @Column(name = "business_name")
    private String businessName;
    
    @Column(name = "password")
    private String password;

    @Column(name = "store_name")
    private String storeName;
    
    @Column(name = "storeId")
    private String storeId;

    @Column(name = "saasId")
    private String saasId;
    
    @Column(name = "expiration")
    private LocalDate expiration;
    
    @Column(name = "city")
    private String city;
	
    @Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;

	@Column(name = "base_currency")
	private String baseCurrencty;
	
	@Column(name = "special_price")
	private String specialPrice;

	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "registerId", unique = true)
    private String registerId;

	@Column(name = "user_type")
    private String userType;
	
    @Column(name = "status")
    private Boolean status;
    
    @Column(name ="BAAR_CODE",columnDefinition = "VARCHAR(50)")
    private String baarCode;
    @Column(name = "CATEGORY_REQ",columnDefinition = "VARCHAR(50)")
    private String categoryReq;
    
    @Column(name="created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "subscription_check",columnDefinition = "VARCHAR(5)")
    private String subscriptionCheck;
    
    @Column(name = "promo_case_check",columnDefinition = "VARCHAR(5)")
    private String promoCaseCheck;
    
    
	@Column(name = "invoice_template")
    private Long template;


	
	
	
}


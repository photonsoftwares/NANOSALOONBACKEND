package com.Img.photon.saloon.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="STORE_MASTER")
public class StoreMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	
	@Column(name="USER_ID")
	private long userId;
	
	@Column(name="STORE_ID", unique = true)
	private String storeId;
	
	@Column(name="SAAS_ID", unique = true)
	private String saasId;
	
	@Column(name="STORE_NAME")
	private String storeName;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="address")
	private String address;
	
	@Column(name="TAXABLE")
	private Boolean taxable;
	
	@Column(name="GST_CODE")
	private String gstCode;
	
	@Column(name ="TNC", columnDefinition = "VARCHAR(255)")
	private String tnc;
	
	@Column(name="HSN_CODE")
	private String hsnCode;
	
	@Column(name="STORE_TYPE")
	private String storeType;
	
	@Column(name="EXCLUSIVE_TAX")
	private BigDecimal exclusiveTax;
	
	@Column(name="INCLUSIVE_TAX")
	private BigDecimal inclusiveTax;
	
	@Column(name="STORE_LOGO")
	private String storeLogo;
	
	@Column(name="BANK_ACCOUNT", nullable=false)
	private String bankAccount;
	
	@Column(name="BANK_IFSC", nullable=false)
	private String bankIfsc;
	
	@Column(name="BANK_BRANCH", nullable=false)
	private String bankBranch;
	
	@Column(name="PAYMENT_QR_CODE", nullable=false)
	private String paymentQRCode;
	
	@Column(name="RECEIPT_FORMAT", nullable=false)
	private int receiptFormat;
	
	@Column(name = "EMAIL")
	private String eMail;
	
	@Column(name="PHONE_NO")
	private String phoneNo;
	
	
	@Column(name="check_inventory")
	private String checkInventory;
	
}
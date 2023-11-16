package com.Img.photon.saloon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Img.photon.saloon.model.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByMobileNumber(String mobileNumber);
	List<Customer> findBySaasIdAndStoreId(String saasId, String storeId);
	
	List<Customer> findBySaasId(String saasId);
	
	@Query(value = "SELECT * FROM customer_master WHERE NAME LIKE %:customerName% AND SAAS_ID = :saasId AND STORE_ID = :storeId", nativeQuery = true)
    List<Customer> searchCustomerByName(@Param("customerName") String customerName, @Param("saasId") String saasId, @Param("storeId") String storeId);
	Customer findBySaasIdAndMobileNumber(String saasId, String mobileNumber);
	Customer findByIdAndSaasIdAndStoreId(Long id, String saasId, String storeId);
	List<Customer> findAllBySaasIdAndStoreId(String saasId, String storeId);
	List<Customer> getBySaasIdAndStoreId(String saasId, String storeId);

	@Query(value = "SELECT * FROM customer_master WHERE id=?1", nativeQuery = true)
	Customer findByCustomerId(Long customerId);
	Customer findByMobileNumberAndPassword(String userName, String password);

	
}
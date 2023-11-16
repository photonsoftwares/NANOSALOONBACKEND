package com.Img.photon.saloon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Img.photon.saloon.model.StoreMaster;




public interface StoreMasterRepository extends JpaRepository<StoreMaster, Long> {

	StoreMaster findByUserId(Long userId);
	StoreMaster findBySaasIdAndStoreId(String saasId, String storeId);
	StoreMaster findByStoreId(String storeId);
	@Query(value="select * from store_master", nativeQuery = true)
	List<StoreMaster> getStores();
	
	
	@Query(nativeQuery = true, value = "SELECT DISTINCT store_name FROM store_master WHERE store_id = ?1 AND saas_id = ?2")
    String findDistinctStoreNameByStoreIdAndSaasId(String storeId, String saasId);




}
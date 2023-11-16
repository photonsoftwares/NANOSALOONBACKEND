package com.Img.photon.saloon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Img.photon.saloon.model.SaasMaster;




public interface SaasMasterRepository extends JpaRepository<SaasMaster, Long>{

	SaasMaster findBySaasId(String saasId);

	@Query(value="select * from saas_master", nativeQuery = true)
	List<SaasMaster> getSaas();
	
	@Query(value="select saas_name from saas_master where saas_id=?1", nativeQuery = true)
	String getSaasName(String saasId);
	

}
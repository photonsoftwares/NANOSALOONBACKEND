package com.Img.photon.saloon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Img.photon.saloon.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUserNameAndPassword(String userName, String password);
	User findByUserName(String userName);
	
	@Query(value="select * from user_master",nativeQuery = true)
	List<User> getAllUsers();
	
	@Query(value="select store_name from user_master where saas_id=? and store_id=? and user_type=\"retailer\"",nativeQuery = true)
	String findBySaasIdAndStoreId(String saasId, String storeId);
	User findBySaasIdAndStoreIdAndUserName(String saasId, String storeId, String userName);

	@Query(value="select * from user_master where business_name=?1",nativeQuery = true)
	User findByBusinessName(String businessName);
	List<User> getBySaasIdAndStoreId(String saasId, String storeId);
	
	User findByUserIdAndSaasIdAndStoreId(Long id, String saasId, String storeId);
	

}
package com.Img.photon.saloon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Img.photon.saloon.model.AddressMaster;


public interface AddressMasterRepository extends JpaRepository<AddressMaster, Long>{

	 @Query(value = "select * from address_master where id=?1 and saas_id=?2 and store_id=?3"  ,nativeQuery =true)
	 Optional<AddressMaster> findByIdAndSaasIdAndStoreId(long addressId,String saasId,String storeId);

	 @Query(value = "select * from address_master where id=?1 and customer_id=?2 and saas_id=?3 and store_id=?4"  ,nativeQuery =true)
	AddressMaster findByIdAndCustomerIdAndSaasIdAndStoreId(long addressId, long customerId, String saasId,
			String storeId);

	 @Query(value = "select id from address_master where customer_id=?1 and status=?2"  ,nativeQuery =true)
	List<Long> findByCustomerId(long id,String status);

	@Query(value = "SELECT * FROM address_master WHERE id IN(:addressIds) AND customer_id = :customerId AND saas_id = :saasId AND store_id = :storeId", nativeQuery = true)
   List<AddressMaster> findAddressMasterByIdsAndCustomerIdAndSaasIdAndStoreId(@Param("addressIds") List<Long> addressIds, @Param("customerId") Long customerId, @Param("saasId") String saasId, @Param("storeId") String storeId);

	List<AddressMaster> findAllByCustomerIdAndSaasIdAndStoreId(Long customerId, String saasId, String storeId);


//	@Query(value = "SELECT * FROM address_master WHERE customer_id = :customerId AND saas_id = :saasId AND store_id = :storeId", nativeQuery = true)
//	List<AddressMaster> getAllByCustomerIdAndSaasIdAndStoreId(@Param("customerId") Long customerId, @Param("saasId") String saasId, @Param("storeId") String storeId);

}
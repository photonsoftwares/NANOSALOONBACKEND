package com.Img.photon.saloon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Img.photon.saloon.model.OtpEntity;




public interface OtpRepository extends JpaRepository<OtpEntity, Long>
{
	
	
	@Query(nativeQuery = true, value = "select * from otp_master where mobile_no=?1 and otp=?2 and is_Validated=0")
	OtpEntity findByMobileNoAndOtp(String mobileNo,Long otp);
	
	@Query(nativeQuery = true, value = "select * from otp_master where mobile_no=?1 and is_Validated=0 ORDER BY created_date DESC limit 1")
	OtpEntity findByMobileNo(String mobileNo);
}

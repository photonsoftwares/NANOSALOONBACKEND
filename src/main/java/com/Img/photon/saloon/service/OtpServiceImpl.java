package com.Img.photon.saloon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Img.photon.saloon.repository.OtpRepository;



@Service
public class OtpServiceImpl implements OtpService{

	@Autowired
	private OtpRepository otpRepository;

	/*
	
	@Override
	public long generateRegistrationOtp(String mobileNo) {

	    OtpEntity entity = new OtpEntity();
	    entity.setMobileNo(mobileNo);
	    entity.setCreatedDate(LocalDateTime.now());
	    entity.setValidated(false);
	    long otp = (long) Math.floor(1000 + Math.random() * 9000);
	    entity.setOtp(otp);
	    otpRepository.save(entity);
	    sendSms(mobileNo,otp);
	    return otp;

	}
	
	
	
	
	@Override
	public OtpResponse validateOtp(OtpRequest request){
		OtpResponse response=new OtpResponse();
		OtpEntity entity=otpRepository.findByMobileNoAndOtp(request.getMobileNo(),request.getOtp());
		
 		
		if(entity==null)
		{
			throw new CustomException(false,"OTP Validation Failed!!");
		}
		entity.setValidated(true);
		otpRepository.save(entity);
		response.setStatus(true);
		response.setOtp(entity.getOtp());
		response.setMessage("OTP Validated Successfully");

		return response;
	}

	
	
	
	
	@Override
	public OtpResponse resendOtp(String mobileNumber) {
		 OtpEntity entity = new OtpEntity();
		 
		    entity.setMobileNo(mobileNumber);
		    entity.setCreatedDate(LocalDateTime.now());
		    entity.setValidated(false);
		    long otp = (long) Math.floor(1000 + Math.random() * 9000);
		    entity.setOtp(otp);
		    otpRepository.save(entity);
		    sendSms(mobileNumber, otp);
		    
			OtpResponse response=new OtpResponse();
			response.setStatus(true);
			response.setMessage("OTP Send Successfully");
		    return response;	
		    
	
	}


	public void sendSms(String mobileNo,long otp)
	{
		
		
		 
        
        // Set the API endpoint URL
        String apiUrl = "https://www.fast2sms.com/dev/bulkV2";
        String route = "dlt";
        String variables=otp+"|";
        
        String flash = "0";
        try {
            StringBuilder fullUrl = new StringBuilder(apiUrl);
            fullUrl.append("?authorization=").append(authToken)
                    .append("&route=").append(route)
                    .append("&sender_id=").append(senderId)
                    .append("&message=").append(messageId)
                    .append("&variables_values=").append(variables)
                    .append("&flash=").append(flash)
                    .append("&numbers=").append(mobileNo);

            URL urlObject = new URL(fullUrl.toString());
            HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                
                System.out.println(response+mobileNo);
               
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	*/
	

}

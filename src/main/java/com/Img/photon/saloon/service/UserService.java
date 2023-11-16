package com.Img.photon.saloon.service;

import com.Img.photon.saloon.request.CustomerSignUpRequest;
import com.Img.photon.saloon.request.RegisterUserRequest;
import com.Img.photon.saloon.request.UserLoginRequest;
import com.Img.photon.saloon.request.UserMasterRequest;
import com.Img.photon.saloon.request.UserRequest;
import com.Img.photon.saloon.response.FinalResponse;
import com.Img.photon.saloon.response.PaginationResponse;



public interface UserService  {

	FinalResponse createUser(UserRequest userRequest);

	FinalResponse userRegister(RegisterUserRequest request);

	FinalResponse loginUser(UserLoginRequest request);

	FinalResponse addUser(UserMasterRequest masterRequest);

	FinalResponse updateUser(UserMasterRequest masterRequest, Long userId);

	FinalResponse deleteUser(Long userId);

	PaginationResponse getUsers(int page);

	FinalResponse customerSignUp(CustomerSignUpRequest customerSignUpRequest);

	
	FinalResponse getStoreNameOfRetailer(String saasId, String storeId);

	FinalResponse nanoPosLogin(UserLoginRequest request);
	
	FinalResponse loginByBusinessName(String businessName);

	FinalResponse getUserDetails(String saasId, String storeId);
	
}

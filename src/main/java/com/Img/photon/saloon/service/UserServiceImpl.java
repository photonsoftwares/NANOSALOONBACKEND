package com.Img.photon.saloon.service;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Img.photon.saloon.exception.CustomException;
import com.Img.photon.saloon.model.Customer;
import com.Img.photon.saloon.model.StoreMaster;
import com.Img.photon.saloon.model.User;
import com.Img.photon.saloon.repository.AddressMasterRepository;
import com.Img.photon.saloon.repository.CustomerRepository;
import com.Img.photon.saloon.repository.SaasMasterRepository;
import com.Img.photon.saloon.repository.StoreMasterRepository;
import com.Img.photon.saloon.repository.UserRepository;
import com.Img.photon.saloon.request.CustomerSignUpRequest;
import com.Img.photon.saloon.request.RegisterUserRequest;
import com.Img.photon.saloon.request.UserLoginRequest;
import com.Img.photon.saloon.request.UserMasterRequest;
import com.Img.photon.saloon.request.UserRequest;
import com.Img.photon.saloon.response.CustomerProfileResponse;
import com.Img.photon.saloon.response.FinalResponse;
import com.Img.photon.saloon.response.PaginationResponse;
import com.Img.photon.saloon.response.StoreNameResponse;
import com.Img.photon.saloon.response.UserAuthResponse;
import com.Img.photon.saloon.response.UserLoginResponse;
import com.Img.photon.saloon.response.UserMasterResponse;
import com.Img.photon.saloon.response.UserResponse;
//import com.Img.photon.saloon.utility.JwtUtil;


@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private AddressMasterRepository addressMasterRepository;
    
    @Autowired
    private StoreMasterRepository storeMasterRepository;
    
    @Autowired
    private SaasMasterRepository saasMasterRepository;
    
//    
//    @Autowired(required = true)
//	JwtUtil jwtUtil;
    




    @Override
    public FinalResponse createUser(UserRequest userRequest) {
    	FinalResponse finalResponse = new FinalResponse();
    	 UserResponse userResponse = new UserResponse();
    	try {
    	User savedUser = userRepository.findByUserNameAndPassword(userRequest.getUserName(), userRequest.getPassword());

    	if(savedUser!= null) {
    	
        userResponse.setUserId(savedUser.getUserId());
        userResponse.setUserName(savedUser.getUserName());
        userResponse.setStoreId(savedUser.getStoreId());
        userResponse.setSaasId(savedUser.getSaasId());
        userResponse.setRegisterId(savedUser.getRegisterId());
        userResponse.setStatus(savedUser.getStatus());
        userResponse.setCategoryReq(savedUser.getCategoryReq());
        userResponse.setBaarCode(savedUser.getBaarCode());
        
        finalResponse.setStatus(true);
        finalResponse.setMessage("User login successfully");
        finalResponse.setData(userResponse);
    	}
    	else {
    		finalResponse.setStatus(false);
            finalResponse.setMessage("Incorrect username or password");
            finalResponse.setData(userResponse);
    	}
        

    	}catch(Exception e) {
    		
    		finalResponse.setStatus(false);
            finalResponse.setMessage("invalid value enter");
            finalResponse.setData(userResponse);
    		
    	}
        return finalResponse;
    }

	@Override
	public FinalResponse userRegister(RegisterUserRequest request) {
		FinalResponse response =  new FinalResponse();
		if(userRepository.findByUserName(request.getUserName()) != null) {
			throw new CustomException( false,"User Name already exists!");
		}
		
		try {
			User newUser = new User();
			StoreMaster newStoreMaster = new StoreMaster();
			BeanUtils.copyProperties(newStoreMaster, request);
			BeanUtils.copyProperties(newUser, request);
			newUser.setCreatedAt(LocalDateTime.now());
			newUser.setStatus(true);
			
			User savedUser = userRepository.save(newUser);
			newStoreMaster.setUserId(savedUser.getUserId());
			StoreMaster savedStoreMaster = storeMasterRepository.save(newStoreMaster);

			UserAuthResponse authResponse = new UserAuthResponse();
			authResponse.setUserData(savedUser);
			authResponse.setStoreData(savedStoreMaster);
		//	authResponse.setJwtResponse(jwtUtil.generateToken(newUser.getUserName()));
			
			response.setData(authResponse);
			response.setStatus(true);
			response.setMessage("User has been registered!");
		}catch(Exception e) {
			throw new CustomException(false, "User Registration Unsuccessful!");
		}
		return response;
	}
	
	@Override
	public FinalResponse loginUser(UserLoginRequest request) {
		FinalResponse response = new FinalResponse();
		if(request.getUserName()=="" || request.getPassword()=="") {
			throw new CustomException( false,"Please fill Username and Password fields!");
		}
		

		
		try {
			Customer cm=customerRepository.findByMobileNumberAndPassword(request.getUserName(), request.getPassword());
			User user = userRepository.findByUserNameAndPassword(request.getUserName(), request.getPassword());		
			UserAuthResponse authResponse = new UserAuthResponse();
		
			
		 	
			
			if(cm!=null)
			{
				
			//	StoreMaster storeLogoByCustomer = storeMasterRepository.findBySaasIdAndStoreId(cm.getSaasId(),cm.getStoreId());	
			
				List<Long> address=addressMasterRepository.findByCustomerId(cm.getId(),"active");
				authResponse.setCustomerData(cm);
			//	authResponse.setJwtResponse(jwtUtil.generateToken(cm.getMobileNumber()));
//				
				//StoreMaster storeName = storeMasterRepository.findBySaasIdAndStoreId(cm.getSaasId(), cm.getStoreId()) ;
				//authResponse.setStoreName(storeLogoByCustomer.getStoreName());				
				if(!address.isEmpty())
				{
					authResponse.setAddressData(address);

				}
				//authResponse.setJwtResponse(jwtUtil.generateToken(user.getUserName()));
				
				if(user!=null) {
					authResponse.setUserData(user);
					authResponse.setStoreData(storeMasterRepository.findByUserId(user.getUserId()));
				//	authResponse.setJwtResponse(jwtUtil.generateToken(user.getUserName()));

					StoreMaster storeName1 = storeMasterRepository.findBySaasIdAndStoreId(user.getSaasId(), user.getStoreId());
					authResponse.setStoreName(storeName1.getStoreName());
					
										
				}
				
				response.setData(authResponse);
				response.setStatus(true);
				response.setMessage("User Login Successeful!");
				
				return response;
			}
			
			
			if(user!=null) {
				//SaasMaster storeLogoByUser = saasMasterRepository.findBySaasId(user.getSaasId());			
				
			//	StoreMaster storeLogoByUser = storeMasterRepository.findBySaasIdAndStoreId(user.getSaasId(),user.getStoreId());	
				
				
				authResponse.setUserData(user);
				authResponse.setStoreData(storeMasterRepository.findByUserId(user.getUserId()));
			//	authResponse.setJwtResponse(jwtUtil.generateToken(user.getUserName()));
				
				StoreMaster storeName1 = storeMasterRepository.findBySaasIdAndStoreId(user.getSaasId(), user.getStoreId());
				authResponse.setStoreName(storeName1.getStoreName());
									
			}
			
			response.setData(authResponse);
			response.setStatus(true);
			response.setMessage("User Login Successeful!");
			
			//return response;
			
			if(user == null && cm==null) {
				throw new CustomException( false,"Username or Password is incorrrect..!!");
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
			throw new CustomException(false, "User Login Unsuccessful!");
		}
		
		return response;
	}

	
	
	
/*

	@Override
	public FinalResponse loginUser(UserLoginRequest request) {
		FinalResponse response = new FinalResponse();
		if(request.getUserName()=="" || request.getPassword()=="") {
			throw new CustomException( false,"Please fill Username and Password fields!");
		}
		try {
			User user = userRepository.findByUserNameAndPassword(request.getUserName(), request.getPassword());
			if(user == null) {
				throw new CustomException( false,"Username or Password is incorrrect..!!");
			}
			UserAuthResponse authResponse = new UserAuthResponse();
			authResponse.setUserData(user);
			authResponse.setStoreData(storeMasterRepository.findByUserId(user.getUserId()));
			Customer cm=customerRepository.findByMobileNumber(request.getUserName());
			if(cm!=null)
			{
				List<Long> address=addressMasterRepository.findByCustomerId(cm.getId(),"active");
				authResponse.setCustomerData(cm);
				if(!address.isEmpty())
				{
					authResponse.setAddressData(address);
				}
			}
			authResponse.setJwtResponse(jwtUtil.generateToken(user.getUserName()));
			
			response.setData(authResponse);
			response.setStatus(true);
			response.setMessage("User Login Successeful!");
		}catch(Exception e) {
			System.out.println(e);
			throw new CustomException(false, "User Login Unsuccessful!");
		}
		return response;
	}

	
	*/
	
	@Override
	public FinalResponse addUser(UserMasterRequest masterRequest) {
		
		User user = new User();
		user.setUserName(masterRequest.getUserName());
		user.setPassword(masterRequest.getPassword());
		user.setStoreName(masterRequest.getStoreName());
		user.setStoreId(masterRequest.getStoreId());
		user.setUserType(masterRequest.getUserType());
		user.setStatus(masterRequest.getStatus());
		user.setMobileNumber(masterRequest.getMobileNumber());
		user.setSaasId(masterRequest.getSaasId());
		user.setBaseCurrencty(masterRequest.getBaseCurrencty());
		user.setCategoryName(masterRequest.getCategoryName());
		user.setSpecialPrice(masterRequest.getSpecialPrice());
		user.setRegisterId(masterRequest.getRegisterId());
		user.setExpiration(masterRequest.getExpiration());
		user.setCreatedAt(masterRequest.getCreatedAt());
		user.setState(masterRequest.getState());
		user.setCountry(masterRequest.getCountry());
		user.setCity(masterRequest.getCity());
		user.setCategoryReq(masterRequest.getCategoryReq());
		user.setBaarCode(masterRequest.getBaarCode());
		
		UserMasterResponse masterResponse =  mapToResponse(userRepository.save(user));
		
			
		
		FinalResponse finalResponse = new FinalResponse();
		finalResponse.setStatus(true);
		finalResponse.setMessage("User Created Successfully");
		finalResponse.setData(masterResponse);
		return finalResponse;
	}
	
	

	private UserMasterResponse mapToResponse(User userEntity) {
		UserMasterResponse masterResponse = new UserMasterResponse();
		masterResponse.setUserName(userEntity.getUserName());
		masterResponse.setPassword(userEntity.getPassword());
		masterResponse.setStoreName(userEntity.getStoreName());
		masterResponse.setStoreId(userEntity.getStoreId());
		masterResponse.setStatus(userEntity.getStatus());
		masterResponse.setSaasId(userEntity.getSaasId());
		masterResponse.setCategoryName(userEntity.getCategoryName());
		masterResponse.setSpecialPrice(userEntity.getSpecialPrice());
		
		masterResponse.setRegisterId(userEntity.getRegisterId());
		masterResponse.setExpiration(userEntity.getExpiration());
		masterResponse.setCreatedAt(userEntity.getCreatedAt());
		masterResponse.setState(userEntity.getState());
		masterResponse.setCountry(userEntity.getCountry());
		masterResponse.setCity(userEntity.getCity());
		masterResponse.setBaarCode(userEntity.getBaarCode());
		masterResponse.setCategoryReq(userEntity.getCategoryReq());
		return masterResponse;
	}

	@Override
	public FinalResponse updateUser(UserMasterRequest masterRequest, Long userId) {
		
		FinalResponse finalResponse = new FinalResponse();
		
		try  {
			Optional<User> findById = userRepository.findById(userId);
			User userEntity = findById.get();
			
			userEntity.setUserName(masterRequest.getUserName());
			userEntity.setPassword(masterRequest.getPassword());
			userEntity.setStoreName(masterRequest.getStoreName());
			userEntity.setStoreId(masterRequest.getStoreId());
			userEntity.setStatus(masterRequest.getStatus());
			userEntity.setSaasId(masterRequest.getSaasId());
			userEntity.setRegisterId(masterRequest.getRegisterId());
			userEntity.setExpiration(masterRequest.getExpiration());
			userEntity.setCreatedAt(masterRequest.getCreatedAt());
			userEntity.setState(masterRequest.getState());
			userEntity.setCountry(masterRequest.getCountry());
			userEntity.setCity(masterRequest.getCity());
			userEntity.setBaarCode(masterRequest.getBaarCode());
			userEntity.setCategoryReq(masterRequest.getCategoryReq());
					
			UserMasterResponse masterResponse =  mapToResponse(userRepository.save(userEntity));
	
			finalResponse.setStatus(true);
			finalResponse.setMessage("User Updated Successfully");
			finalResponse.setData(masterResponse);
		
		}catch(Exception e) {
			finalResponse.setStatus(false);
			finalResponse.setMessage("User Id Not Found");
			finalResponse.setData(null);
		}
		return finalResponse;
	}

	
	
	@Override
	public FinalResponse deleteUser(Long userId) {
		FinalResponse finalResponse = new FinalResponse();
		
		try {
			Optional<User> findById = userRepository.findById(userId);
			User userEntity = findById.get();
			userRepository.delete(userEntity);
			finalResponse.setStatus(true);
			finalResponse.setMessage("User Deleted Successfully");
			finalResponse.setData(userEntity);
		}catch(Exception e) {
			finalResponse.setStatus(false);
			finalResponse.setMessage("User Id Not Found");
			finalResponse.setData(null);
			
		}
		
		return finalResponse;
	}

	
	@Override
	public PaginationResponse getUsers(int page) {
		
		PaginationResponse finalResponse = new PaginationResponse();
		List<User> allUsers = userRepository.getAllUsers();
		
		List<UserMasterResponse> userList = new ArrayList<>();
		for(User masterRequest: allUsers) {
			UserMasterResponse masterResponse = new UserMasterResponse();
			masterResponse.setUserName(masterRequest.getUserName());
			masterResponse.setPassword(masterRequest.getPassword());
			masterResponse.setMobileNumber(masterRequest.getMobileNumber());
			masterResponse.setStoreName(masterRequest.getStoreName());
			masterResponse.setStoreId(masterRequest.getStoreId());
			masterResponse.setStatus(masterRequest.getStatus());
			masterResponse.setSaasId(masterRequest.getSaasId());
			masterResponse.setRegisterId(masterRequest.getRegisterId());
			masterResponse.setExpiration(masterRequest.getExpiration());
			masterResponse.setCreatedAt(masterRequest.getCreatedAt());
			masterResponse.setState(masterRequest.getState());
			masterResponse.setCountry(masterRequest.getCountry());
			masterResponse.setCity(masterRequest.getCity());
			masterResponse.setBaarCode(masterRequest.getBaarCode());
			masterResponse.setCategoryReq(masterRequest.getCategoryReq());
			
			userList.add(masterResponse);
		}
		

		finalResponse.setCount(userList.size());
		
		int limit =10;
		int startIndex=(page-1) * limit;
	    int endIndex=(page) * limit;
	    userList=userList.subList(startIndex, Math.min(endIndex, userList.size()));
	    
		
		finalResponse.setStatus(true);
		finalResponse.setMessage("User Details Fetched");
		finalResponse.setData(userList);
		
		
		return finalResponse;
	}

	

	
	@Override
	public FinalResponse customerSignUp(CustomerSignUpRequest customerSignUpRequest) {
		
		
		FinalResponse finalResponse = new FinalResponse();
		if(customerRepository.findByMobileNumber(customerSignUpRequest.getMobileNumber()) != null) {
			finalResponse.setStatus(false);
			finalResponse.setMessage("Customer already register in this number");
			finalResponse.setData(null);
			return finalResponse;
		}
		
		try {
			
			Customer customer = Customer.builder()
					.mobileNumber(customerSignUpRequest.getMobileNumber()) 
					.name(customerSignUpRequest.getUserName())
					.email(customerSignUpRequest.getPassword())
					.password(customerSignUpRequest.getPassword())
					.storeId(customerSignUpRequest.getStoreId())
					.saasId(customerSignUpRequest.getSaasId())
					.status(customerSignUpRequest.getStatus())
					.build();
		//BeanUtils.copyProperties(customer, customerSignUpRequest);
				
//		customer.setMobileNumber(customerSignUpRequest.getMobileNumber());
//		customer.setEmail(customerSignUpRequest.getEmail());
//		customer.setName(customerSignUpRequest.getUserName());
////
//		customer.setPassword(customerSignUpRequest.getPassword());	
//		customer.setSaasId(customerSignUpRequest.getSaasId());	
//	
//		customer.setStoreId(customerSignUpRequest.getStoreId());
		
		customerRepository.save(customer);
		
//		OtpRequest otpRequest = new OtpRequest();
//		otpRequest.setMobileNo(customerSignUpRequest.getMobileNumber());
//		otpRequest.setOtp(generateRegistrationOtp);;
//		
//		OtpResponse validateOtp = otpService.validateOtp(otpRequest);	
//
//		Customer customerEntity =null;
//		if(validateOtp!=null) {
//			
//		}
		
	
//		
//		customerSignUpResponse.setMobileNumber(customerEntity.getMobileNumber());
//		customerSignUpResponse.setEmail(customerEntity.getEmail());
//		customerSignUpResponse.setCustomerName(customerEntity.getName());
		//	customerSignUpResponse.setCustomerName(user.getUserName());
	//	customerSignUpResponse.setStoreName(userEntity.getStoreName());
//		customerSignUpResponse.setPassword(customerEntity.getPassword());	
//		customerSignUpResponse.setSaasId(customerEntity.getSaasId());
//		customerSignUpResponse.setStoreId(customerEntity.getStoreId());
		
	//	otpService.generateRegistrationOtp(customerSignUpRequest.getMobileNumber());
		
		finalResponse.setStatus(true);
		finalResponse.setMessage("Registration Successful");
		finalResponse.setData(null);
		
		
		return finalResponse;
		
		}catch(Exception e) {
			throw new CustomException( false, e.getMessage());
		}
	}

	
	
	
	
	
	

	@Override
	public FinalResponse getStoreNameOfRetailer(String saasId, String storeId) {
		FinalResponse finalResponse = new FinalResponse();
		StoreNameResponse storeNames = new StoreNameResponse(); 
		try {
			String storeName = userRepository.findBySaasIdAndStoreId(saasId, storeId);
			
			storeNames.setStoreName(storeName);			
			finalResponse.setData(storeNames);
			finalResponse.setMessage("Store Name Fetched");
			finalResponse.setStatus(true);

		}catch(Exception e) {
			throw new CustomException(e.getMessage());
		}
		return finalResponse;
		
	}

	@Override
	public FinalResponse nanoPosLogin(UserLoginRequest request) {
		
		FinalResponse response = new FinalResponse();
		if(request.getUserName()=="" || request.getPassword()=="") {
			throw new CustomException( false,"Please fill Username and Password fields!");
		}
		try {
			User user = userRepository.findByUserNameAndPassword(request.getUserName(), request.getPassword());
			if(user == null) {
				throw new CustomException( false,"Username or Password is incorrrect..!!");
			}
			
			UserMasterResponse masterResponse = new UserMasterResponse();
			BeanUtils.copyProperties(masterResponse, user);
			
			response.setData(masterResponse);
			response.setStatus(true);
			response.setMessage("User Login Successeful!");
		}catch(Exception e) {
			throw new CustomException(false, "User Login Unsuccessful!");
		}
		return response;
	}

	@Override
	public FinalResponse loginByBusinessName(String businessName) {
		FinalResponse finalResponse = new FinalResponse();
		UserLoginResponse login=new UserLoginResponse();
		try {
	    	User entity = userRepository.findByBusinessName(businessName);
	    	login.setUserName(entity.getUserName());
	    	login.setPassword(entity.getPassword());
	    	finalResponse.setData(login);
			finalResponse.setMessage("SUCCESS");
			finalResponse.setStatus(true);

		}catch(Exception e) {
			throw new CustomException(e.getMessage());
		}
		return finalResponse;
	
	}

	@Override
	public FinalResponse getUserDetails(String saasId, String storeId) {
		
		FinalResponse finalResponse = new FinalResponse();

	//	List<User> bySaasIdAndStoreId = userRepository.getBySaasIdAndStoreId(saasId, storeId);
		
		List<Customer> bySaasIdAndStoreId = customerRepository.getBySaasIdAndStoreId(saasId,storeId);
		List<CustomerProfileResponse> userResponse = new ArrayList<>();
		for(Customer getCustomer: bySaasIdAndStoreId) {	
			CustomerProfileResponse response = new CustomerProfileResponse();
			
			response.setId(getCustomer.getId());
//			response.setCustomerId(getCustomer.getCustomerId());
			response.setName(getCustomer.getName());
			
			response.setEmail(getCustomer.getEmail());
			response.setMobileNumber(getCustomer.getMobileNumber());
			response.setSaasId(getCustomer.getSaasId());
			response.setStoreId(getCustomer.getStoreId());			
			userResponse.add(response);
		}
		
		
		
		finalResponse.setData(userResponse);
		finalResponse.setStatus(true);
		finalResponse.setMessage("User Detail Fetched!");
		
		return finalResponse;
		
	}
		
		


}
	


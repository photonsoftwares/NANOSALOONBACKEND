package com.Img.photon.saloon.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Img.photon.saloon.request.CustomerSignUpRequest;
import com.Img.photon.saloon.request.RegisterUserRequest;
import com.Img.photon.saloon.request.UserLoginRequest;
import com.Img.photon.saloon.response.FinalResponse;
import com.Img.photon.saloon.service.UserService;


@RestController
@RequestMapping("/api/v1/auth")

public class AuthController {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/user-registration")
	public FinalResponse userRegister(@RequestBody RegisterUserRequest request) {
		return userService.userRegister(request);
	}
	
	// http://localhost:8092/api/v1/auth/customer-sign-up
	
	
	@PostMapping("/customer-sign-up")
	public FinalResponse userRegister(@RequestBody CustomerSignUpRequest request) {
		return userService.customerSignUp(request);
	}
	
	@PostMapping("/user-login")
	public FinalResponse loginUser(@RequestBody UserLoginRequest request) {
		return userService.loginUser(request);
	}
	
	@PostMapping("/nano-pos-login")
	public FinalResponse nanologinUser(@RequestBody UserLoginRequest request) {
		return userService.nanoPosLogin(request);
	}
	
	
}

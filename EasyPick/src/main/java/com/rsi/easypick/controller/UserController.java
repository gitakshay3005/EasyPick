package com.rsi.easypick.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rsi.easypick.products.beans.ProductSearchResponse;
import com.rsi.easypick.user.beans.UserBean;
import com.rsi.easypick.user.beans.UserLoginRequest;
import com.rsi.easypick.user.beans.UserResponse;

@CrossOrigin
@RestController
@RequestMapping(value = "/easypick/api")
public class UserController {
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
	public HttpEntity<UserResponse> registerUser(@RequestBody(required = true)UserBean bean)
	{
		UserResponse userResponse = new UserResponse(bean.getId(), bean.getFirstName(), bean.getLastName(), bean.getEmailId(), bean.getUserType());
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public HttpEntity<UserResponse> login(@RequestBody(required = true)UserLoginRequest loginRequest)
	{
		
		UserResponse userResponse = new UserResponse("6", "akshay", "sawant", "akshay.sawant@retailsolutions.com", "c");
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
	}
	

}

package com.rsi.easypick.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EasyPickStoreController {

	@RequestMapping(value = {"/stores/v1/fetchStores","/stores/v1/fetchStores"}, method = RequestMethod.POST)
	public HttpEntity<String> getStoresData(@RequestBody(required = true) String Data){
		
		return new ResponseEntity<String>("hello", HttpStatus.OK);
	}
}

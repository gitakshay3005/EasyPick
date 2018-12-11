package com.rsi.easypick.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rsi.easypick.stores.bean.StoreSearchRequest;
import com.rsi.easypick.stores.bean.StoreSearchResponse;
import com.rsi.easypick.stores.manager.StoreSearchManager;

@RestController
public class EasyPickStoreController {
	@Autowired
	private StoreSearchManager storeSearchManager;
	
	@RequestMapping(value = {"/stores/v1/fetchStores","/stores/v1/fetchStores"}, method = RequestMethod.GET)
	public HttpEntity<StoreSearchResponse> getStoresData(@RequestBody(required = true) StoreSearchRequest storeSearchRequest){
		StoreSearchResponse storeSearchResponse = storeSearchManager.getStores(storeSearchRequest.getProductQuantityList());
		return new ResponseEntity<StoreSearchResponse>(storeSearchResponse, HttpStatus.OK);
	}
}

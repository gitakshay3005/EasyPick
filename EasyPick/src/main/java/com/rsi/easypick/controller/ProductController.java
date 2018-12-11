package com.rsi.easypick.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rsi.easypick.products.beans.ProductBean;
import com.rsi.easypick.products.beans.ProductSearchResponse;

@CrossOrigin
@RestController
@RequestMapping(value = "/easypick/api")
public class ProductController {

	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<ProductSearchResponse> searchProductsByText(@RequestParam(required=true) String text) {
		List<ProductBean> products = new ArrayList<ProductBean>();
		products.add(new ProductBean(1, "Test 1", "Sample", "21212121545", "test", "Nestle"));
		products.add(new ProductBean(2, "Test 2", "Sample", "21212121545", "test", "Nestle"));
		products.add(new ProductBean(3, "Test 3", "Sample", "21212121545", "test", "Nestle"));
		ProductSearchResponse productSearchResponse = new ProductSearchResponse();
		productSearchResponse.setProducts(products);
		return new ResponseEntity<ProductSearchResponse>(productSearchResponse, HttpStatus.OK);
	}
	
}

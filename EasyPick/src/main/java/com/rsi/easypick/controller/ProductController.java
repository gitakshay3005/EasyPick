package com.rsi.easypick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rsi.easypick.exceptions.DatabaseException;
import com.rsi.easypick.products.beans.ProductSearchResponse;
import com.rsi.easypick.products.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping(value = "/easypick/api")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<ProductSearchResponse> searchProductsByText(@RequestParam(required=true) String text) throws DatabaseException {
		ProductSearchResponse productSearchResponse = productService.getProductsByText(text);
		return new ResponseEntity<ProductSearchResponse>(productSearchResponse, HttpStatus.OK);
	}
	
}

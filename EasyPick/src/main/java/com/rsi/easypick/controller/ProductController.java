package com.rsi.easypick.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rsi.easypick.model.Product;

@CrossOrigin
@RestController
@RequestMapping(value = "/easypick/api")
public class ProductController {

	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json")
	public List<Product> searchProductsByText(@RequestParam(required=true) String text) {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, "Test 1", "Sample", "21212121545", "test", "Nestle"));
		products.add(new Product(2, "Test 2", "Sample", "21212121545", "test", "Nestle"));
		products.add(new Product(3, "Test 3", "Sample", "21212121545", "test", "Nestle"));
		return products;
	}
	
}

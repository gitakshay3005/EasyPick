package com.rsi.easypick.products.service;

import org.springframework.web.multipart.MultipartFile;

import com.rsi.easypick.exceptions.DatabaseException;
import com.rsi.easypick.products.beans.ProductSearchResponse;

public interface ProductService {
	
	ProductSearchResponse getProductsByText(String searchText) throws DatabaseException;
	
	ProductSearchResponse getProductsByImage(MultipartFile file) throws Exception;

}

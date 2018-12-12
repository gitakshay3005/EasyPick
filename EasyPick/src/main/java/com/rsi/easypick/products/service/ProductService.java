package com.rsi.easypick.products.service;

import com.rsi.easypick.exceptions.DatabaseException;
import com.rsi.easypick.products.beans.ProductSearchResponse;

public interface ProductService {
	
	ProductSearchResponse getProductsByText(String searchText) throws DatabaseException;

}

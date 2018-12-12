package com.rsi.easypick.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rsi.easypick.exceptions.DatabaseException;
import com.rsi.easypick.products.beans.ProductBean;
import com.rsi.easypick.products.beans.ProductSearchResponse;
import com.rsi.easypick.products.dao.ProductsDao;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductsDao productsDao;

	@Override
	public ProductSearchResponse getProductsByText(String searchText) throws DatabaseException {
		// TODO Auto-generated method stub
		List<ProductBean> products = productsDao.getProductsByText(searchText);
		ProductSearchResponse productSearchResponse = new ProductSearchResponse();
		productSearchResponse.setProducts(products);
		productSearchResponse.setResponseCode(HttpStatus.OK.name());
		productSearchResponse.setResponseMessage(HttpStatus.OK.name());
		return productSearchResponse;
	}

}

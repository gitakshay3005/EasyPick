package com.rsi.easypick.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rsi.easypick.exceptions.DatabaseException;
import com.rsi.easypick.products.beans.ProductBean;
import com.rsi.easypick.products.beans.ProductSearchResponse;
import com.rsi.easypick.products.dao.ProductsDao;
import com.rsi.easypick.utils.OCRUtils;

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

	@Override
	public ProductSearchResponse getProductsByImage(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		List<String> scannedStrings = OCRUtils.detectHandwrittenOcr(file);
		List<ProductBean> products = productsDao.getProductsByStringList(scannedStrings);
		ProductSearchResponse productSearchResponse = new ProductSearchResponse();
		productSearchResponse.setProducts(products);
		productSearchResponse.setResponseCode(HttpStatus.OK.name());
		productSearchResponse.setResponseMessage(HttpStatus.OK.name());
		return productSearchResponse;
	}

}

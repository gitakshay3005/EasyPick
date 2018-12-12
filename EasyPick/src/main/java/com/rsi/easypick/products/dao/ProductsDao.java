package com.rsi.easypick.products.dao;

import java.util.List;

import com.rsi.easypick.exceptions.DatabaseException;
import com.rsi.easypick.products.beans.ProductBean;

public interface ProductsDao {
	
	List<ProductBean> getProductsByText(String searchText) throws DatabaseException;
	
	List<ProductBean> getProductsByStringList(List<String> scannedStrings) throws DatabaseException;

}

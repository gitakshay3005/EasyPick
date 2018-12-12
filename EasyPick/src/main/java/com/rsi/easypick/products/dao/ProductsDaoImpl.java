package com.rsi.easypick.products.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rsi.easypick.exceptions.DatabaseException;
import com.rsi.easypick.products.beans.ProductBean;

@Repository
public class ProductsDaoImpl implements ProductsDao {
	
	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBean> getProductsByText(String searchText) throws DatabaseException {
		// TODO Auto-generated method stub
		List<ProductBean> products = new ArrayList<ProductBean>();
		try {
			List<Object[]> results = entityManager.createNativeQuery("SELECT * FROM PRODUCT WHERE NAME LIKE :searchText OR UPC LIKE :searchText OR DESCRIPTION LIKE :searchText OR CATEGORY LIKE :searchText OR SUPPLIER LIKE :searchText").setParameter("searchText", "%" + searchText + "%").getResultList();
			if(results != null && !results.isEmpty()) {
				for(Object[] result : results) {
					ProductBean product = new ProductBean();
					if(result[0] != null) {
						product.setId(Long.parseLong(result[0].toString()));
					}
					if(result[1] != null) {
						product.setUpc(result[1].toString());
					}
					if(result[2] != null) {
						product.setName(result[2].toString());
					}
					if(result[3] != null) {
						product.setCategory(result[3].toString());
					}
					if(result[4] != null) {
						product.setDescription(result[4].toString());
					}
					if(result[5] != null) {
						product.setSupplier(result[5].toString());
					}
					products.add(product);
				}
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
		return products;
	}

}

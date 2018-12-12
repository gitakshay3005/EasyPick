package com.rsi.easypick.products.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
		} catch(NoResultException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
		return products;
	}

	@Override
	public List<ProductBean> getProductsByStringList(List<String> scannedStrings) throws DatabaseException {
		List<ProductBean> products = new ArrayList<ProductBean>();
		try {
			if(scannedStrings == null || scannedStrings.isEmpty())
				return products;
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * FROM PRODUCT WHERE ");
			for(int i = 0; i < scannedStrings.size(); i++) {
				String scannedString = "'%" + scannedStrings.get(i) + "%'";
				sql.append("NAME LIKE " + scannedString +" OR UPC LIKE " + scannedString + " OR DESCRIPTION LIKE " + scannedString + " OR CATEGORY LIKE " + scannedString + " OR SUPPLIER LIKE " + scannedString + " ");
				if(i < scannedStrings.size() - 1)
					sql.append("OR ");
			}
			@SuppressWarnings("unchecked")
			List<Object[]> results = entityManager.createNativeQuery(sql.toString()).getResultList();
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
		} catch(NoResultException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
			throw new DatabaseException(e.getMessage());
		}
		return products;
	}

}

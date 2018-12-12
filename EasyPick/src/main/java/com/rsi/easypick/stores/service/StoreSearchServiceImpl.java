package com.rsi.easypick.stores.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rsi.easypick.stores.bean.ProductQuantityBean;
import com.rsi.easypick.stores.bean.StoreProductInformation;

@Component
public class StoreSearchServiceImpl implements StoreSearchService{
	public List<StoreProductInformation> getStoreProductInformation(List<ProductQuantityBean> productList){

		List<StoreProductInformation> storeProductInfoList = new ArrayList<>();


		StoreProductInformation storeProductInformation = new StoreProductInformation();
		storeProductInformation.setStoreId("101");
		storeProductInformation.setStoreName("Target Kalyani");
		storeProductInformation.setCity("Pune");
		storeProductInformation.setRetailer("Target");
		storeProductInformation.setDistance("1.2 KM");
		storeProductInformation.setTotalPrice(520.6);
		
		List<ProductQuantityBean> productQuantityList = new ArrayList<>();
		ProductQuantityBean productQuantityBean = new ProductQuantityBean();
		productQuantityBean.setDepartment("Food");
		productQuantityBean.setProductId("2002");
		productQuantityBean.setProductName("Maggie double pack");
		productQuantityBean.setQuantity(10);
		productQuantityBean.setSupplier("Nestle");
		productQuantityBean.setUnitPrice(10.0);
		
		ProductQuantityBean productQuantityBean1 = new ProductQuantityBean();
		productQuantityBean1.setDepartment("Soap");
		productQuantityBean1.setProductId("1001");
		productQuantityBean1.setProductName("Lux");
		productQuantityBean1.setQuantity(5);
		productQuantityBean1.setSupplier("Lux");
		productQuantityBean1.setUnitPrice(15.0);
		
		productQuantityList.add(productQuantityBean);
		productQuantityList.add(productQuantityBean1);
	
		storeProductInformation.setProductList(productQuantityList);
		storeProductInformation.setAvailability(productQuantityList.size());
		
		storeProductInfoList.add(storeProductInformation);
		
		StoreProductInformation storeProductInformation1 = new StoreProductInformation();
		storeProductInformation1.setStoreId("102");
		storeProductInformation1.setStoreName("Walgreens Smart");
		storeProductInformation1.setCity("Pune");
		storeProductInformation1.setRetailer("Walgreens");
		storeProductInformation1.setTotalPrice(520.6);
		storeProductInformation1.setDistance("2.3 KM");
		
		List<ProductQuantityBean> productQuantityList1 = new ArrayList<>();
		ProductQuantityBean productQuantityBean2 = new ProductQuantityBean();
		productQuantityBean2.setDepartment("Food");
		productQuantityBean2.setProductId("2002");
		productQuantityBean2.setProductName("Maggie double pack");
		productQuantityBean2.setQuantity(10);
		productQuantityBean2.setSupplier("Nestle");
		productQuantityBean2.setUnitPrice(10.0);
		
		ProductQuantityBean productQuantityBean3 = new ProductQuantityBean();
		productQuantityBean3.setDepartment("Soap");
		productQuantityBean3.setProductId("1001");
		productQuantityBean3.setProductName("Lux");
		productQuantityBean3.setQuantity(5);
		productQuantityBean3.setSupplier("Lux");
		productQuantityBean3.setUnitPrice(15.0);
		productQuantityList1.add(productQuantityBean3);
		productQuantityList1.add(productQuantityBean2);
	
		storeProductInformation1.setProductList(productQuantityList1);
		storeProductInformation1.setAvailability(productQuantityList1.size());

		
		storeProductInfoList.add(storeProductInformation1);
		
		StoreProductInformation storeProductInformation2 = new StoreProductInformation();
		storeProductInformation2.setStoreId("103");
		storeProductInformation2.setStoreName("Kroger Fresh");
		storeProductInformation2.setCity("Pune");
		storeProductInformation2.setRetailer("Kroger");
		storeProductInformation2.setTotalPrice(549.6);
		storeProductInformation2.setDistance("5.6 KM");
		
		List<ProductQuantityBean> productQuantityList2 = new ArrayList<>();
		ProductQuantityBean productQuantityBean4 = new ProductQuantityBean();
		productQuantityBean4.setDepartment("Food");
		productQuantityBean4.setProductId("2002");
		productQuantityBean4.setProductName("Maggie double pack");
		productQuantityBean4.setQuantity(10);
		productQuantityBean4.setSupplier("Nestle");
		productQuantityBean4.setUnitPrice(9.0);
		
		ProductQuantityBean productQuantityBean5= new ProductQuantityBean();
		productQuantityBean5.setDepartment("Soap");
		productQuantityBean5.setProductId("1001");
		productQuantityBean5.setProductName("Lux");
		productQuantityBean5.setQuantity(5);
		productQuantityBean5.setSupplier("Lux");
		productQuantityBean5.setUnitPrice(13.50);
		productQuantityList2.add(productQuantityBean4);
		productQuantityList2.add(productQuantityBean5);
	
		storeProductInformation2.setProductList(productQuantityList2);
		storeProductInformation2.setAvailability(productQuantityList2.size());

		
		storeProductInfoList.add(storeProductInformation1);
		return storeProductInfoList;
	}
}

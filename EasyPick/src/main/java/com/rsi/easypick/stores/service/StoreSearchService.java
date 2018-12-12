package com.rsi.easypick.stores.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rsi.easypick.stores.bean.ProductQuantityBean;
import com.rsi.easypick.stores.bean.StoreProductInformation;

@Component
public interface StoreSearchService {
	public List<StoreProductInformation> getStoreProductInformation(List<ProductQuantityBean> productList);
	
}

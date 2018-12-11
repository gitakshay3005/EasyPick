package com.rsi.easypick.stores.manager;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rsi.easypick.stores.bean.ProductQuantityBean;
import com.rsi.easypick.stores.bean.StoreSearchResponse;

@Component
public class StoreSearchManager {

	public StoreSearchResponse getStores(List<ProductQuantityBean> productList){
		StoreSearchResponse storeSearchResponse = new StoreSearchResponse();
		return storeSearchResponse;
	}
}

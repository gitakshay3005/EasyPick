package com.rsi.easypick.stores.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.rsi.easypick.stores.bean.ProductQuantityBean;
import com.rsi.easypick.stores.bean.StoreProductInformation;
import com.rsi.easypick.stores.bean.StoreSearchResponse;
import com.rsi.easypick.stores.service.StoreSearchService;


@Component
public class StoreSearchManager {
@Autowired
StoreSearchService storeSearchService;
	public StoreSearchResponse getStores(List<ProductQuantityBean> productList){
		StoreSearchResponse storeSearchResponse = new StoreSearchResponse();
		List<StoreProductInformation> storeProductInfo = storeSearchService.getStoreProductInformation(productList);
		storeSearchResponse.setStoreProductInfo(storeProductInfo);
		storeSearchResponse.setResponseCode(String.valueOf(HttpStatus.OK));
		storeSearchResponse.setResponseMessage(HttpStatus.OK.getReasonPhrase());
		return storeSearchResponse;
	}
}

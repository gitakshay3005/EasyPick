package com.rsi.easypick.stores.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class StoreSearchRequest {
	private List<ProductQuantityBean> productQuantityList;

	@JsonCreator
	public StoreSearchRequest(@JsonProperty("productQuantityList")List<ProductQuantityBean> productQuantityList) {
		super();
		this.productQuantityList = productQuantityList;
	}

	public StoreSearchRequest() {
		super();
	}

	public List<ProductQuantityBean> getProductQuantityList() {
		return productQuantityList;
	}

	public void setProductQuantityList(List<ProductQuantityBean> productQuantityList) {
		this.productQuantityList = productQuantityList;
	}

}

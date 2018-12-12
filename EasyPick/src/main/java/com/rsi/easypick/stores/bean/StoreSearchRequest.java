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
	private String longitude;
	private String latitude;
	private List<ProductQuantityBean> productQuantityList;

	@JsonCreator
	public StoreSearchRequest(@JsonProperty("productQuantityList")List<ProductQuantityBean> productQuantityList,
			@JsonProperty("longitude")String longitude, @JsonProperty("latitue")String latitude) {
		super();
		this.productQuantityList = productQuantityList;
		this.longitude = longitude;
		this.latitude = latitude;
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

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	

}

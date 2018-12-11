package com.rsi.easypick.stores.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class StoreSearchResponse {
	private List<StoreProductInformation> storeProductInfo;
	private String responseCode;
	private String responseMessage;
	
	@JsonCreator
	public StoreSearchResponse(@JsonProperty("storeProductInfo")List<StoreProductInformation> storeProductInfo, 
			@JsonProperty("responseCode")String responseCode, @JsonProperty("responseMessage")String responseMessage) {
		super();
		this.storeProductInfo = storeProductInfo;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}
	public StoreSearchResponse() {
		super();
	}
	public List<StoreProductInformation> getStoreProductInfo() {
		return storeProductInfo;
	}
	public void setStoreProductInfo(List<StoreProductInformation> storeProductInfo) {
		this.storeProductInfo = storeProductInfo;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}

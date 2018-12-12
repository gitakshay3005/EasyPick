package com.rsi.easypick.products.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ProductSearchResponse {

	private List<ProductBean> products;
	private String responseCode;
	private String responseMessage;
	
	@JsonCreator
	public ProductSearchResponse(@JsonProperty("products")List<ProductBean> products, 
			@JsonProperty("responseCode")String responseCode, @JsonProperty("responseMessage")String responseMessage) {
		super();
		this.products = products;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}
	public ProductSearchResponse() {
		super();
	}
	public List<ProductBean> getProducts() {
		return products;
	}
	public void setProducts(List<ProductBean> products) {
		this.products = products;
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

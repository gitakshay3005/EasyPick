package com.rsi.easypick.stores.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class StoreProductInformation {
	private String storeId;
	private String storeName;
	private String retailer;
	private String distance;
	private int availability;
	private double totalPrice;
	private List<ProductQuantityBean> productList;
	
	
	@JsonCreator
	public StoreProductInformation(@JsonProperty("storeId")String storeId, @JsonProperty("storeName")String storeName, @JsonProperty("retailer")String retailer, 
			@JsonProperty("distance")String distance, @JsonProperty("availability")int availability,
			double totalPrice, List<ProductQuantityBean> productList) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.retailer = retailer;
		this.distance = distance;
		this.availability = availability;
		this.totalPrice = totalPrice;
		this.productList = productList;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getRetailer() {
		return retailer;
	}
	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<ProductQuantityBean> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductQuantityBean> productList) {
		this.productList = productList;
	}




}

package com.rsi.easypick.stores.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ProductQuantityBean {
	private String productId;
	private String productName;
	private String department;
	private String supplier;
	private double unitPrice;
	private int quantity;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	@JsonCreator
	public ProductQuantityBean(@JsonProperty("productId")String productId, @JsonProperty("productName")String productName, 
			@JsonProperty("department")String department, @JsonProperty("supplier")String supplier, @JsonProperty("quantity")int quantity,
			@JsonProperty("unitPrice")double unitPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.department = department;
		this.supplier = supplier;
		this.quantity = quantity;
		this.unitPrice =  unitPrice;
	}
	
	public ProductQuantityBean() {
		super();
	}

}

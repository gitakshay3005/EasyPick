package com.rsi.easypick.model;

public class Product {

	private long id;
	private String name;
	private String description;
	private String upc;
	private String category;
	private String supplier;
	
	public Product(long id, String name, String description, String upc, String category, String supplier) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.upc = upc;
		this.category = category;
		this.supplier = supplier;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
}

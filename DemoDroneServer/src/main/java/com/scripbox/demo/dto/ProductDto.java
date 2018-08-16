package com.scripbox.demo.dto;

import java.time.format.DateTimeFormatter;

public class ProductDto {
	private int id;
	private String productName;
	private String serialNumber;
	private String productStatus;
	private String productAddedDate;
	private String productDeliveredDate;
	private String deliveredBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getProductAddedDate() {
		return productAddedDate;
	}

	public void setProductAddedDate(String productAddedDate) {
		this.productAddedDate = productAddedDate;
	}

	public String getProductDeliveredDate() {
		return productDeliveredDate;
	}

	public void setProductDeliveredDate(String productDeliveredDate) {
		this.productDeliveredDate = productDeliveredDate;
	}

	public String getDeliveredBy() {
		return deliveredBy;
	}

	public void setDeliveredBy(String deliveredBy) {
		this.deliveredBy = deliveredBy;
	}

	public void setProductAddedDate(Object object, DateTimeFormatter formatter) {
		// TODO Auto-generated method stub
		
	}

}

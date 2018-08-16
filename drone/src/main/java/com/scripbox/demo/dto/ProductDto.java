package com.scripbox.demo.dto;

import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.scripbox.demo.constants.ScripBoxConstants;

public class ProductDto {
	private int id;
	private String productName;
	private String serialNumber;
	private String productStatus = ScripBoxConstants.PRODUCT_INSTOCK;
	private String productAddedDate;
	private String productDeliveredDate;
	private String deliveredBy;
	private String address;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

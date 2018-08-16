package com.scripbox.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private int id;
	private String product_name;
	private String serial_number;
	private String product_status;
	private Date product_added_date;
	private Date product_delivered_date;
	private int deliveredBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public String getProduct_status() {
		return product_status;
	}

	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}

	public Date getProduct_added_date() {
		return product_added_date;
	}

	public void setProduct_added_date(Date product_added_date) {
		this.product_added_date = product_added_date;
	}

	public Date getProduct_delivered_date() {
		return product_delivered_date;
	}

	public void setProduct_delivered_date(Date product_delivered_date) {
		this.product_delivered_date = product_delivered_date;
	}

	public int getDeliveredBy() {
		return deliveredBy;
	}

	public void setDeliveredBy(int deliveredBy) {
		this.deliveredBy = deliveredBy;
	}

	
}

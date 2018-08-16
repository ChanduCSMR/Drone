package com.scripbox.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.scripbox.demo.constants.ScripBoxConstants;

@Entity
public class Drone {
	@Id
	@GeneratedValue
	private int id;
	private String drone_name;
	private String version_number;
	private String status = ScripBoxConstants.DRONE_READY_STATUS;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDrone_name() {
		return drone_name;
	}

	public void setDrone_name(String drone_name) {
		this.drone_name = drone_name;
	}

	public String getVersion_number() {
		return version_number;
	}

	public void setVersion_number(String version_number) {
		this.version_number = version_number;
	}

}

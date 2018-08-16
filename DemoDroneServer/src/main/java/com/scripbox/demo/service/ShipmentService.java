package com.scripbox.demo.service;

import com.scripbox.demo.dto.DroneDto;

public interface ShipmentService {

	DroneDto getAvailableDrone(int productID);

	String proceedToDeliver(int productID);

	String unloadProduct(int droneID, int productID);

}

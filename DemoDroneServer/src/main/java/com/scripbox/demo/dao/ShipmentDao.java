package com.scripbox.demo.dao;

import com.scripbox.demo.entity.Drone;

public interface ShipmentDao {

	Drone getAvailableDrone(int productID);

	String proceedToDeliver(int droneID);

	String unloadProduct(int droneID, int productID);

}

package com.scripbox.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scripbox.demo.constants.ScripBoxConstants;
import com.scripbox.demo.dao.ShipmentDao;
import com.scripbox.demo.dto.DroneDto;
import com.scripbox.demo.entity.Drone;
import com.scripbox.demo.service.ShipmentService;

@Service
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	ShipmentDao shipmentDao;

	@Override
	public DroneDto getAvailableDrone(int productID) {
		Drone drone = shipmentDao.getAvailableDrone(productID);
		if (drone == null) {
			return null;
		}
		DroneDto droneDto = new DroneDto();
		droneDto.setId(drone.getId());
		droneDto.setDroneName(drone.getDrone_name());
		droneDto.setVersionNumber(drone.getVersion_number());
		return droneDto;
	}

	@Override
	public String proceedToDeliver(int droneID) {

		String status = shipmentDao.proceedToDeliver(droneID);
		if (status != null) {
			return ScripBoxConstants.SUCCESS;
		} else {
			return ScripBoxConstants.FAILURE;
		}
	}

	@Override
	public String unloadProduct(int droneID, int productID) {
		String status = shipmentDao.unloadProduct(droneID, productID);
		if (status != null) {
			return ScripBoxConstants.SUCCESS;
		} else {
			return ScripBoxConstants.FAILURE;
		}
	}
}

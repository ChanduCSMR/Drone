package com.scripbox.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scripbox.demo.dto.DroneDto;
import com.scripbox.demo.service.ShipmentService;

@RestController
public class ShipmentController {

	@Autowired
	ShipmentService shipmentService;

	// command center initiate the shipment for specified product and  it will hit this controller and automatically
	// choose one available drone from database/parking plot and change product and
	// drone status, drone will pick the product and send details to command center for verification.
	@RequestMapping(method = RequestMethod.POST, value = "/service/initiateShipment")
	public DroneDto initiateShipment(@RequestParam("productID") int productID) {

		DroneDto droneDto = shipmentService.getAvailableDrone(productID);

		return droneDto;
	}

	// After successful verification from command center drone will start/ move to delivery address, address will find by either by google map or by any other input.
	// After reaching specified address drone send a notification to command center for reached status.
	@RequestMapping(method = RequestMethod.POST, value = "/service/proceedDelivery")
	public String proceedDelivery(@RequestParam("droneID") int droneID) {

		String status = shipmentService.proceedToDeliver(droneID);

		return status;
	}

	//After getting response from command center drone going to deliver the product in address and it will again send a notification to command center to inform successful delivery.
	// And drone will going back to parking spot and it sets status READY for next shipment. And product status updating from Out for delivery to delivered. 
	@RequestMapping(method = RequestMethod.POST, value = "/service/unloadProduct")
	public String unloadProduct(@RequestParam("droneID") int droneID, @RequestParam("productID") int productID) {

		String status = shipmentService.unloadProduct(droneID, productID);

		return status;
	}

}
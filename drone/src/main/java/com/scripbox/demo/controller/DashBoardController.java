package com.scripbox.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scripbox.demo.dto.DroneDto;
import com.scripbox.demo.dto.ProductDto;
import com.scripbox.demo.service.DashBoardService;

@Controller
public class DashBoardController {
	@Autowired
	DashBoardService dashBoardService;

	@RequestMapping(value = "/dashboard.htm", method = RequestMethod.GET)
	public String loadDashBorad(Model model) {
		// fetching all drones and products details
		List<DroneDto> drones = dashBoardService.getAllDrones();
		List<ProductDto> products = dashBoardService.getAllProducts();
		if (drones != null) {
			model.addAttribute("drones", drones);
		}
		if (products != null) {
			model.addAttribute("products", products);
		}

		return "dashboard";
	}

}

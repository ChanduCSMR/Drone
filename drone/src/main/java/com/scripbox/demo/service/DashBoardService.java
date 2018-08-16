package com.scripbox.demo.service;

import java.util.List;

import com.scripbox.demo.dto.DroneDto;
import com.scripbox.demo.dto.ProductDto;

public interface DashBoardService {

	List<DroneDto> getAllDrones();

	List<ProductDto> getAllProducts();

}

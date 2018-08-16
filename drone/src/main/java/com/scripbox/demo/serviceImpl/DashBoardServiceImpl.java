package com.scripbox.demo.serviceImpl;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scripbox.demo.dao.DashBoardDao;
import com.scripbox.demo.dto.DroneDto;
import com.scripbox.demo.dto.ProductDto;
import com.scripbox.demo.entity.Drone;
import com.scripbox.demo.service.DashBoardService;

@Service
public class DashBoardServiceImpl implements DashBoardService {

	@Autowired
	DashBoardDao dashBoardDao;

	@Override
	public List<DroneDto> getAllDrones() {
		// TODO Auto-generated method stub
		List<DroneDto> droneDtos = new ArrayList<>();
		List<Drone> drones = dashBoardDao.getAllDrones();
		for (Drone drone : drones) {
			DroneDto droneDto = new DroneDto();
			droneDto.setDroneName(drone.getDrone_name());
			droneDto.setId(drone.getId());
			droneDto.setVersionNumber(drone.getVersion_number());
			droneDto.setStatus(drone.getStatus());
			droneDtos.add(droneDto);
		}
		return droneDtos;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<ProductDto> getAllProducts() {
		// TODO Auto-generated method stub

		List<Object[]> products = dashBoardDao.getAllProducts();
		List<ProductDto> productDtos = new ArrayList<>();
		if (!products.isEmpty()) {
			for (Object[] product : products) {
				ProductDto productDto = new ProductDto();
				productDto.setProductName((String) product[0]);
				productDto.setSerialNumber((String) product[1]);
				productDto.setProductStatus((String) product[2]);
				productDto.setProductAddedDate((String) product[3].toString());
				if (product[4] != null) {
					productDto.setProductDeliveredDate((String) product[4].toString());
				}
				productDto.setDeliveredBy((String) product[5]);
				productDto.setId((int) product[6]);
				productDto.setAddress((String) product[7]);
				productDtos.add(productDto);
			}
			return productDtos;
		} else {
			return null;
		}

	}

}

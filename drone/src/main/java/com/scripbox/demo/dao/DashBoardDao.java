package com.scripbox.demo.dao;

import java.util.List;

import com.scripbox.demo.entity.Drone;

public interface DashBoardDao {

	List<Drone> getAllDrones();

	List<Object[]> getAllProducts();

}

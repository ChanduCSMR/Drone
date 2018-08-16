package com.scripbox.demo.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scripbox.demo.dao.DashBoardDao;
import com.scripbox.demo.entity.Drone;
import com.scripbox.demo.util.SessionUtility;

@Repository
@Transactional
public class DashBoardDaoImpl implements DashBoardDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	SessionUtility sessionUtility;

	@SuppressWarnings("unchecked")
	@Override
	public List<Drone> getAllDrones() {
		List<Drone> drones = null;
		try {
			Session session = sessionUtility.getSession(entityManager);
			drones = session.createQuery("From Drone ").list();
			return drones;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return drones;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAllProducts() {
		List<Object[]> products = null;
		try {
			Session session = sessionUtility.getSession(entityManager);
			products = session.createQuery(
					"select product_name,serial_number,product_status,product_added_date,product_delivered_date,( select drone_name from Drone where id = p.deliveredBy),p.id,address From Product p ")
					.list();
			return products;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return products;
	}

}

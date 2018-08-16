package com.scripbox.demo.daoImpl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scripbox.demo.constants.ScripBoxConstants;
import com.scripbox.demo.dao.ShipmentDao;
import com.scripbox.demo.entity.Drone;
import com.scripbox.demo.util.SessionUtility;

@Repository
@Transactional
public class ShipmentDaoImpl implements ShipmentDao {

	@Autowired
	SessionUtility sessionUtility;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Drone getAvailableDrone(int productID) {
		Drone drone = null;
		try {
			Session session = sessionUtility.getSession(entityManager);
			drone = (Drone) session.createQuery("from Drone where status=:status")
					.setParameter("status", ScripBoxConstants.DRONE_READY_STATUS).setMaxResults(1).uniqueResult();
			if (drone != null) {
				session.createQuery("update Drone set status=:status where id=:id")
						.setParameter("status", ScripBoxConstants.DRONE_SHIIPING_STATUS)
						.setParameter("id", drone.getId()).executeUpdate();
				session.createQuery("update Product set product_status=:status where id=:id")
						.setParameter("status", ScripBoxConstants.PRODUCT_OUT_FOR_DELIVERY)
						.setParameter("id", productID).executeUpdate();
				return drone;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return drone;
		}
	}

	@Override
	public String proceedToDeliver(int droneID) {

		String status = null;
		try {
			Session session = sessionUtility.getSession(entityManager);
			session.createQuery("update Drone set status=:status where id=:id")
					.setParameter("status", ScripBoxConstants.DRONE_ADDRESS_REACHED_STATUS).setParameter("id", droneID)
					.executeUpdate();
			status = ScripBoxConstants.DRONE_ADDRESS_REACHED_STATUS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String unloadProduct(int droneID, int productID) {
		try {
			Session session = sessionUtility.getSession(entityManager);
			session.createQuery("update Drone set status=:status where id=:id")
					.setParameter("status", ScripBoxConstants.DRONE_READY_STATUS).setParameter("id", droneID)
					.executeUpdate();
			session.createQuery(
					"update Product set product_status=:status,product_delivered_date=:deliverdate,deliveredBy=:droneId where id=:id")
					.setParameter("status", ScripBoxConstants.PRODUCT_DELIVERED).setParameter("id", productID)
					.setParameter("deliverdate", new Date()).setParameter("droneId", droneID).executeUpdate();
			return ScripBoxConstants.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ScripBoxConstants.FAILURE;
		}
	}

}

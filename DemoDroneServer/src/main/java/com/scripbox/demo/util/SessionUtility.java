package com.scripbox.demo.util;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class SessionUtility {
	
	public Session getSession(EntityManager entityManager) {
		return entityManager.unwrap(Session.class);
	}

}

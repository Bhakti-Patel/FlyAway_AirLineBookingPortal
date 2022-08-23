package org.simplilearn.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.simplilearn.app.entities.Airlines;
import org.simplilearn.app.entities.City;
import org.simplilearn.app.util.HibConfig;

public class AdminDaoImpl implements AdminDao {

	@Override
	public List<Airlines> getAirlinesList() {
		
		
		System.out.println("Inside AdminDaoImpl..............");
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<Airlines> query = session.createQuery("select a from org.simplilearn.app.entities.Airlines a");
		
		return query.list();
		
	}

}

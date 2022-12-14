package org.simplilearn.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.simplilearn.app.entities.City;
import org.simplilearn.app.util.HibConfig;
import org.hibernate.Query;
public class CityDaoImpl implements CityDao {

	@Override
	public List getSourceList() {
		
		System.out.println("Inside CityDaoImpl..............");
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<City> query = session.createQuery("select c.source from org.simplilearn.app.entities.City c order by c.source asc");
		
		return query.list();
	}

	@Override
	public List getDestinationList() {
		
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<City> query = session.createQuery("select c.destination from org.simplilearn.app.entities.City c order by c.destination desc");
		
		return query.list();
	}

}

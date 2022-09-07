package org.simplilearn.app.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.simplilearn.app.entities.Airlines;
import org.simplilearn.app.util.HibConfig;

public class FlightDaoImpl implements FlightDao{

	@Override
	public List<Airlines> getAirlineDetails(String source,String destination,Date departureDate) {
		
		
		System.out.println("Inside FlightDaoImpl..............");
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		
		
		Query<Airlines> query = session.createQuery("select a from org.simplilearn.app.entities.Airlines a where a.source=:source and a.destination=:destination");
		query.setParameter("source",source);
		query.setParameter("destination",destination);
		
		
		
		return query.list();
	}

}

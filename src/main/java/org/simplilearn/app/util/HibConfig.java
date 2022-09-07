package org.simplilearn.app.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.simplilearn.app.entities.Airlines;
import org.simplilearn.app.entities.City;
import org.simplilearn.app.entities.Flight;
import org.simplilearn.app.entities.Passenger;
import org.simplilearn.app.entities.TicketSummary;
import org.simplilearn.app.entities.User;

public class HibConfig {
	public static SessionFactory getSessionFactory() {
		Configuration configuration=new Configuration();
		configuration.setProperties(hibernateProperties());
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(City.class);
		configuration.addAnnotatedClass(Passenger.class);
		configuration.addAnnotatedClass(Flight.class);
		configuration.addAnnotatedClass(Airlines.class);
		configuration.addAnnotatedClass(TicketSummary.class);
		



		return configuration.buildSessionFactory();
	}
	private static Properties hibernateProperties() {
		System.out.println("Inside HibConfig...........");
		Properties properties=new Properties();
		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.URL, "jdbc:mysql://localhost:3306/airlinebookingdb");
		properties.put(Environment.USER, "root");
		properties.put(Environment.PASS, "root");
		properties.put(Environment.SHOW_SQL, true);
		properties.put(Environment.FORMAT_SQL, true);
		properties.put(Environment.HBM2DDL_AUTO, "update");
		properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		return properties;
		
	}
}

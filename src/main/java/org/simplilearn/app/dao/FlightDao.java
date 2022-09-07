package org.simplilearn.app.dao;

import java.util.Date;
import java.util.List;

import org.simplilearn.app.entities.Airlines;
import org.simplilearn.app.entities.Flight;

public interface FlightDao{
	
	List<Airlines> getAirlineDetails(String source,String destination,Date departureDate);

}

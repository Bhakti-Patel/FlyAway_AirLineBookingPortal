package org.simplilearn.app.dao;

import java.util.Date;
import java.util.List;

import org.simplilearn.app.entities.Flight;
import org.simplilearn.app.entities.Passenger;
import org.simplilearn.app.entities.TicketSummary;

public interface PassengerDao {
	
	
	int savePassengerDetails(Passenger psg);
	int saveFlightDetails(int passengerId,int airlineId,Date departureDate);
	List getFlightDetails(int bookingId);
}

package org.simplilearn.app.entities;

import java.util.Date;
import java.util.List;


public class TicketSummary {
	
	   String firstName;
	   String lastName;
	    String airlineName;
	    String flightNo;
	    String source;
	    String destination;
	    Date departureDate;
	    String departureTime;
	    int totalSeats;
	    int ticketPrice;
	    int airlineId;
	    
	    List<TicketSummary> tktsummary;
	    
	   
		public TicketSummary() {
	    	
	    }
	    public TicketSummary(String firstName, String lastName, String airlineName, String flightNo, String source,
				String destination, Date departureDate, String departureTime, int totalSeats, int ticketPrice,
				int airlineId) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.airlineName = airlineName;
			this.flightNo = flightNo;
			this.source = source;
			this.destination = destination;
			this.departureDate = departureDate;
			this.departureTime = departureTime;
			this.totalSeats = totalSeats;
			this.ticketPrice = ticketPrice;
			this.airlineId = airlineId;
		}
	    public List<TicketSummary> getTktsummary() {
			return tktsummary;
		}
		public void setTktsummary(List<TicketSummary> tktsummary) {
			this.tktsummary = tktsummary;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getAirlineName() {
			return airlineName;
		}
		public void setAirlineName(String airlineName) {
			this.airlineName = airlineName;
		}
		public String getFlightNo() {
			return flightNo;
		}
		public void setFlightNo(String flightNo) {
			this.flightNo = flightNo;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public String getDestination() {
			return destination;
		}
		public void setDestination(String destination) {
			this.destination = destination;
		}
		public Date getDepartureDate() {
			return departureDate;
		}
		public void setDepartureDate(Date departureDate) {
			this.departureDate = departureDate;
		}
		public String getDepartureTime() {
			return departureTime;
		}
		public void setDepartureTime(String departureTime) {
			this.departureTime = departureTime;
		}
		public int getTotalSeats() {
			return totalSeats;
		}
		public void setTotalSeats(int totalSeats) {
			this.totalSeats = totalSeats;
		}
		public int getTicketPrice() {
			return ticketPrice;
		}
		public void setTicketPrice(int ticketPrice) {
			this.ticketPrice = ticketPrice;
		}
		public int getAirlineId() {
			return airlineId;
		}
		public void setAirlineId(int airlineId) {
			this.airlineId = airlineId;
		}
		

}

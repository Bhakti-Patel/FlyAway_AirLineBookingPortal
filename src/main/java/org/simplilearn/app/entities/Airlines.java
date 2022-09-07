package org.simplilearn.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airlines {
	
	@Id
	private int airlineId;
	private String airlineName;
	private String flightNo;
	private String source;
	private String destination;
	private String departureTime;
	private String arrivalTime;
	private int ticketPrice;
	private Date departureDate;
	private Date arrivalDate;
	
	public Airlines() {
		
	}
	

	public Airlines(int airlineId, String airlineName, String flightNo, String source, String destination,
			String departureTime, String arrivalTime, int ticketPrice, Date departureDate, Date arrivalDate) {
		super();
		this.airlineId = airlineId;
		this.airlineName = airlineName;
		this.flightNo = flightNo;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.ticketPrice = ticketPrice;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
	}


	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
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

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTIme(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	

}

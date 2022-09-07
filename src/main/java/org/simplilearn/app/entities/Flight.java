package org.simplilearn.app.entities;

import java.sql.Time;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight_details", schema = "airlinebookingdb")
public class Flight {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	private int airlineId;
	private int passengerId;
	private int totalSeats;
	private int ticketPrice;
	private Date departureDate;
	
	public Flight() {
		
	}

	public Flight(int bookingId, int airlineId, int passengerId, int totalSeats, int ticketPrice,Date departureDate) {
		super();
		this.bookingId = bookingId;
		this.airlineId = airlineId;
		this.passengerId = passengerId;
		this.totalSeats = totalSeats;
		this.ticketPrice = ticketPrice;
		this.departureDate = departureDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
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

	
}

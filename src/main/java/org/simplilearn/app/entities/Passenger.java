package org.simplilearn.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Passenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int passengerId;
	private String firstName;
	private String lastName;
	private String address;
	private String emailId;
	private String mobileNo;
	private String isAdmin;
	private int totalSeats;
	
	public Passenger() {
		
	}
	public Passenger(int passengerId, String firstName, String lastName, String address, String emailId,
			String mobileNo, String isAdmin, int totalSeats) {
		super();
		this.passengerId = passengerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.isAdmin = isAdmin;
		this.totalSeats = totalSeats;
	}
	

	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}


	

}

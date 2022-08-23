package org.simplilearn.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
	
	@Id
	private int cityId;
	private String source;
	private String destination;

	
	public City() {
		
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
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
	public City(int cityId, String source, String destination) {
		super();
		this.cityId = cityId;
		this.source = source;
		this.destination = destination;
	}
	
}

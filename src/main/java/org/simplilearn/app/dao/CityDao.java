package org.simplilearn.app.dao;

import java.util.List;

import org.simplilearn.app.entities.City;

public interface CityDao {
	
	List<City> getSourceList();
	List<City> getDestinationList();

}

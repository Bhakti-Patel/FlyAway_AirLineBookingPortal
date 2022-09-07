package org.simplilearn.app.dao;

import java.util.Optional;

import org.simplilearn.app.entities.User;

public interface UserDao {
	
	boolean validateUser(User user);
	void saveUserDetails(User user);
	int changeAdminPassword(User user);


}

package org.simplilearn.app.dao;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.simplilearn.app.entities.User;
import org.simplilearn.app.util.HibConfig;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean validateUser(User user) {
		System.out.println("Inside UserDao.validateUser method....");
		
	SessionFactory factory=HibConfig.getSessionFactory();
	Session session=factory.openSession();
	User e=session.get(User.class, 1);
if(null == e)
	return false;
	else
		return true;
}

}

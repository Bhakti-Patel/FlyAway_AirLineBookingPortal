package org.simplilearn.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.simplilearn.app.entities.User;
import org.simplilearn.app.util.HibConfig;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean validateUser(User user) {
		System.out.println("Inside UserDao.validateUser method....");
		boolean isExisted = false;
		int userId = 0;
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		//User e = session.get(User.class, 1);
		
		
		Query query = session.createQuery("select u from org.simplilearn.app.entities.User u where username=:username and password =:password and userType =:userType");
		query.setParameter("username", user.getUsername());
		query.setParameter("password", user.getPassword());
		query.setParameter("userType", user.getUsertype());
		
		
		if (query.uniqueResult()!=null) {
			System.out.println("true");
			isExisted = true;
			return isExisted;
		}
		else {
			System.out.println("false");
			return isExisted;
		}
	}

	@Override
	public void saveUserDetails(User user) {
		
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			 session.save(user);
			tx.commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			session.close();
		}
		
	}

	@Override
	public int changeAdminPassword(User user) {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		int result =0;

		try {
			Query query = session.createQuery("update  org.simplilearn.app.entities.User u set u.password=:password where username=:username");
			query.setParameter("password", user.getPassword());
			query.setParameter("username", user.getUsername());
			result = query.executeUpdate();
			System.out.println("Result of Change Password.........."+result);
			tx.commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			session.close();
		}
		return result;
		
	}

}

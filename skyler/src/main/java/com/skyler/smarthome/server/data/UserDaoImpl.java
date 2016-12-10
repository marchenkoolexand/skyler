package com.skyler.smarthome.server.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skyler.smarthome.server.model.User;
import com.skyler.smarthome.server.service.UserService;

@Component
public class UserDaoImpl implements UserDao {

	final static Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean createNewUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(user);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<User> getAllUserWithOutSecureInfo() {
		Session session = sessionFactory.openSession();
		try {
			List<User> userList = session.createQuery("from User").list();

			userList.forEach(user -> {
				user.setPassword("");
				user.setEmail("");
				user.setRecoveryEmail("");
				user.setPhoneNumber("");
			});

			return userList;
		} catch (HibernateException e) {
			return null;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		Session session = sessionFactory.openSession();
		try {
			List<User> userList = session.createQuery("from User").list();
			return userList;
		} catch (HibernateException e) {
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public User getUserById(int id) {
		Session session = sessionFactory.openSession();
		try {
			User user = (User) session.get(User.class, id);
			return user;
		} catch (HibernateException e) {
			return null;
		} finally {

		}
	}

	@Override
	public User getUserByIdWithOutSecureInfo(int id) {
		Session session = sessionFactory.openSession();
		try {
			User user = (User) session.get(User.class, id);
			user.setPassword("");
			user.setEmail("");
			user.setRecoveryEmail("");
			user.setPhoneNumber("");
			
			return user;
		} catch (HibernateException e) {
			return null;
		} finally {

		}
	}

	@Override
	public boolean updateUser(int userId, String userField, String newParam) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			User user = (User) session.get(User.class, userId);
			user = UserService.updateUserByField(user, userField, newParam);
			session.merge(user);
			return true;
		} catch (HibernateException e) {
			return false;
		} finally {
			tx.commit();
			session.close();
		}
	}

	@Override
	public boolean deleteUserById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			User loadedUser = (User) session.get(User.class, id);
			session.delete(loadedUser);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			tx.rollback();
			return false;
		} finally {
			session.close();
		}
	}
}

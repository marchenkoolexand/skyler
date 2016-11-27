package com.skyler.smarthome.server.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.skyler.smarthome.server.model.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void createNewUser(User user) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		session.persist(user);

		tx.commit();

		session.close();
	}

	@Override
	public List<User> getAllUser() {

		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<User> userList = session.createQuery("from User").list();

		session.close();

		return userList;
	}

	@Override
	public User getUserById(int id) {

		Session session = sessionFactory.openSession();

		User user = (User) session.get(User.class, id);

		return user;
	}

	@Override
	public void updateUser(User user) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		session.merge(user);
	
		tx.commit();

		session.close();
	}

	@Override
	public void deleteUserById(int id) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		User loadedUser = (User) session.load(User.class, id);

		session.delete(loadedUser);

		tx.commit();

		session.close();
	}

}

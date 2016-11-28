package com.skyler.smarthome.server.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.skyler.smarthome.server.model.Gateway;

public class GatewayDaoImpl implements GatewayDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Gateway> getAllGateways() {

		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<Gateway> gatewayList = session.createQuery("from Gateway").list();

		session.close();

		return gatewayList;

	}

	@Override
	public Gateway getGatewayById(int id) {

		Session session = sessionFactory.openSession();

		Gateway gateWay = (Gateway) session.get(Gateway.class, id);

		return gateWay;
	}

	@Override
	public void createGateway(Gateway gateway) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		session.persist(gateway);

		tx.commit();

		session.close();

	}

	@Override
	public void deleteGateway(int id) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		Gateway loadedGateway = (Gateway) session.load(Gateway.class, id);

		session.delete(loadedGateway);

		tx.commit();

		session.close();

	}

	@Override
	public void updateGateway(Gateway gateway) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		session.merge(gateway);

		tx.commit();

		session.close();
	}

}

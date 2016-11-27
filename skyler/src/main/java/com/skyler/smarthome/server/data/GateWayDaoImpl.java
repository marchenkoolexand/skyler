package com.skyler.smarthome.server.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.skyler.smarthome.server.model.GateWay;

public class GateWayDaoImpl implements GateWayDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<GateWay> getAllGateWays() {

		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<GateWay> gateWayList = session.createQuery("from GateWay").list();

		session.close();

		return gateWayList;

	}

	@Override
	public GateWay getGateWayById(int id) {

		Session session = sessionFactory.openSession();

		GateWay gateWay = (GateWay) session.get(GateWay.class, id);

		return gateWay;
	}

	@Override
	public void createGateWay(GateWay gateway) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		session.persist(gateway);

		tx.commit();

		session.close();

	}

	@Override
	public void deleteGateWay(int id) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		GateWay loadedGateWay = (GateWay) session.load(GateWay.class, id);

		session.delete(loadedGateWay);

		tx.commit();

		session.close();

	}

	@Override
	public void updateGateWay(GateWay gateWay) {

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		session.merge(gateWay);

		tx.commit();

		session.close();
	}

}

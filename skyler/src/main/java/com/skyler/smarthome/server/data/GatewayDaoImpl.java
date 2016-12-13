package com.skyler.smarthome.server.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skyler.smarthome.server.model.Gateway;
import com.skyler.smarthome.server.service.GatewayService;

@Repository("gatewayDAO")
public class GatewayDaoImpl implements GatewayDao {

	final static Logger logger = Logger.getLogger(GatewayDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Gateway> getAllGateways() {
		Session session = sessionFactory.openSession();
		List<Gateway> gatewayList = new ArrayList<Gateway>();
		try {
			gatewayList = session.createQuery("from Gateway").list();
			return gatewayList;
		} catch (HibernateException e) {

		} finally {
			session.close();
		}
		return gatewayList;
	}

	@Override
	public Gateway getGatewayById(int id) {
		Session session = sessionFactory.openSession();
		try {
			Gateway gateWay = (Gateway) session.get(Gateway.class, id);
			return gateWay;
		} catch (HibernateException e) {
			
		}
		return null;
	}

	@Override
	public boolean createGateway(Gateway gateway) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(gateway);
		} catch (HibernateException e) {
			tx.rollback();
			return false;
		} finally {
			tx.commit();
			session.close();
		}
		return true;

	}

	@Override
	public boolean deleteGateway(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Gateway loadedGateway = (Gateway) session.load(Gateway.class, id);
			session.delete(loadedGateway);
		} catch (HibernateException e) {
			tx.rollback();
			return false;
		} finally {
			tx.commit();
			session.close();
		}
		return true;
	}

	@Override
	public boolean updateGatewayByField(int gatewayId, String gatewayField, String newParam) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Gateway gateway = (Gateway) session.get(Gateway.class, gatewayId);
			gateway = GatewayService.updateGatewayByField(gateway, gatewayField, newParam);
			session.merge(gateway);
		} catch (HibernateException e) {
			tx.rollback();
			return false;
		} finally {
			tx.commit();
			session.close();
		}
		return false;

	}

	@Override
	public boolean updateGateway(Gateway gateway) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.merge(gateway);
		} catch (HibernateException e) {
			tx.rollback();
			return false;
		} finally {
			tx.commit();
			session.close();
		}
		return false;
	}
}

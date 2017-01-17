package com.skyler.smarthome.server.data;

import com.skyler.smarthome.server.model.Gateway;
import com.skyler.smarthome.server.util.GatewayUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("gatewayDAO")
public class GatewayDaoImpl implements GatewayDao {

	final static Logger logger = Logger.getLogger(GatewayDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Gateway> getAllGateways() {
		Session session = sessionFactory.openSession();
		List<Gateway> gatewayList = null;
		try {
			gatewayList = session.createQuery("from com.skyler.smarthome.server.model.Gateway").list();
			return gatewayList;
		} catch (HibernateException e) {
				System.out.println(e);
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
			gateway = GatewayUtil.updateGatewayByField(gateway, gatewayField, newParam);
			session.saveOrUpdate(gateway);
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
			session.saveOrUpdate(gateway);
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

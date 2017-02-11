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
			session.getTransaction().setTimeout(10);
			session.getTransaction().begin();
			gatewayList = session.createQuery("from com.skyler.smarthome.server.model.Gateway").list();
			session.getTransaction().commit();
			return gatewayList;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return gatewayList;
	}

	@Override
	public Gateway getGatewayById(int id) {
		Session session = sessionFactory.openSession();
		try {
			session.getTransaction().setTimeout(10);
			session.getTransaction().begin();
			Gateway gateWay = (Gateway) session.get(Gateway.class, id);
			session.getTransaction().commit();
			return gateWay;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean createGateway(Gateway gateway) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			tx.setTimeout(10);
			tx.begin();
			session.persist(gateway);
			tx.commit();
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
			tx.setTimeout(10);
			tx.begin();
			Gateway loadedGateway = (Gateway) session.load(Gateway.class, id);
			session.delete(loadedGateway);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public boolean updateGatewayByField(int gatewayId, String gatewayField, String newParam) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			tx.setTimeout(10);
			tx.begin();
			Gateway gateway = (Gateway) session.get(Gateway.class, gatewayId);
			gateway = GatewayUtil.updateGatewayByField(gateway, gatewayField, newParam);
			session.saveOrUpdate(gateway);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			return false;
		} finally {
			session.close();
		}
		return false;

	}

	@Override
	public boolean updateGateway(Gateway gateway) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			tx.setTimeout(10);
			tx.begin();
			session.saveOrUpdate(gateway);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			return false;
		} finally {
			session.close();
		}
		return false;
	}
}

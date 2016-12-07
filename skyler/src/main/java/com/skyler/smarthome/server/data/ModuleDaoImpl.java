package com.skyler.smarthome.server.data;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skyler.smarthome.server.enums.SensorStatus;
import com.skyler.smarthome.server.model.Gateway;
import com.skyler.smarthome.server.model.Sensor;
import com.skyler.smarthome.server.service.SensorService;

@Component
public class SensorDaoImpl implements SensorDao {

	final static Logger logger = Logger.getLogger(SensorDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Sensor getSensorById(int id) {
		Session session = sessionFactory.openSession();
		Sensor sensor = (Sensor) session.get(Sensor.class, id);
		return sensor;
	}

	@Override
	public List<Sensor> getAllSensors() {
		Session session = sessionFactory.openSession();
		try {
			@SuppressWarnings("unchecked")
			List<Sensor> sensorList = session.createQuery("from Sensor").list();
			return sensorList;
		} catch (HibernateException e) {

		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Sensor> getSensorByStatus(SensorStatus status) {

		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Sensor where s_sensore_stat = :status ");
			query = SensorService.setSensorStatusForQuery(query, status);
			List<Sensor> list = query.list();
			return list;
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public boolean addSensorToGateway(int gatewayId, Sensor sensor) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Gateway gateway = (Gateway) session.get(Gateway.class, gatewayId);
			gateway.getSensorList().add(sensor);
			session.save(gateway);
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
	public boolean addSensorListToGateway(int gatewayId, List<Sensor> sensorList) {
		Session session = sessionFactory.openSession();
		try {
			Gateway gateway = (Gateway) session.get(Gateway.class, gatewayId);
			Iterator<Sensor> iterator = sensorList.iterator();
			while (iterator.hasNext()) {
				gateway.getSensorList().add(iterator.next());
				session.save(gateway);
			}
		} catch (HibernateException e) {

		} finally {
			session.close();
		}
		return false;

	}

	@Override
	public boolean setSensorStatus(int sensorId, SensorStatus status) {
		Session session = sessionFactory.openSession();
		try {
			Sensor sensor = (Sensor) session.get(Sensor.class, sensorId);
			sensor.setSensorStatus(status);
			session.merge(sensor);
			return true;
		} catch (Exception e) {

		} finally {
			session.close();
		}
		return false;
	}
}

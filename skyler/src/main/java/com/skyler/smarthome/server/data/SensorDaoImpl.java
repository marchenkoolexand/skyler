package com.skyler.smarthome.server.data;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skyler.smarthome.server.enums.SensorStatus;
import com.skyler.smarthome.server.model.Gateway;
import com.skyler.smarthome.server.model.Sensor;

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
		@SuppressWarnings("unchecked")
		List<Sensor> sensorList = session.createQuery("from Sensor").list();
		session.close();
		return sensorList;
	}

	@Override
	public List<Sensor> getSensorByStatus(SensorStatus status) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Sensor where status = :status ");
		query.setParameter("status", status);
		@SuppressWarnings("unchecked")
		List<Sensor> list = query.list();
		return list;
	}

	@Override
	public void addSensorToGateway(int gatewayId, Sensor sensor) {
		Session session = sessionFactory.openSession();
		Gateway gateway = (Gateway) session.get(Gateway.class, gatewayId);
		gateway.getSensorList().add(sensor);
		session.save(gateway);
	}

	@Override
	public void addSensorListToGateway(int gatewayId, List<Sensor> sensorList) {
		Session session = sessionFactory.openSession();
		Gateway gateway = (Gateway) session.get(Gateway.class, gatewayId);
		Iterator<Sensor> iterator = sensorList.iterator();
		while (iterator.hasNext()) {
			gateway.getSensorList().add(iterator.next());
			session.save(gateway);
		}
		session.close();
	}
}

package com.skyler.smarthome.server.data;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.skyler.smarthome.server.enums.SensorStatus;
import com.skyler.smarthome.server.model.Sensor;

public class SensorDaoImpl implements SensorDao {

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

}

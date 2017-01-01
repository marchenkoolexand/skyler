package com.skyler.smarthome.server.data;

import com.skyler.smarthome.server.model.Actuator;
import com.skyler.smarthome.server.model.Device;
import com.skyler.smarthome.server.model.Module;
import com.skyler.smarthome.server.model.Sensor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ModuleDaoImpl implements ModuleDao {

	final static Logger logger = Logger.getLogger(ModuleDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Module> getAllModules() {
		Session session = sessionFactory.openSession();
		try {
			List<Module> moduleList = session.createQuery("from com.skyler.smarthome.server.model.Module").list();
			return moduleList;
		} catch (HibernateException e) {

		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Sensor> getAllSensor() {
		Session session = sessionFactory.openSession();
		try {
			List<Sensor> sensorList = session.createQuery("from Sensor").list();
			return sensorList;
		} catch (HibernateException e) {

		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Actuator> getAllActuator() {
		Session session = sessionFactory.openSession();
		try {
			List<Actuator> actuatorList = session.createQuery("from Actuator").list();
			return actuatorList;
		} catch (HibernateException e) {

		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Sensor getSensorById(int sensorId) {
		Session session = sessionFactory.openSession();
		Sensor sensor = (Sensor) session.get(Sensor.class, sensorId);
		return sensor;
	}

	@Override
	public Actuator getActuatorById(int actuatorId) {
		Session session = sessionFactory.openSession();
		Actuator actuator = (Actuator) session.get(Sensor.class, actuatorId);
		return actuator;
	}

	@Override
	public boolean addModuleToDevice(int deviceId, Module module) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Device device = (Device) session.get(Device.class, deviceId);
			device.addModuleToDevice(module);
			session.save(device);
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
	public boolean addSensorListToDevice(int deviceId, List<Sensor> sensorList) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Device device = (Device) session.get(Device.class, deviceId);
			device.addSensorListToDevice(sensorList);
			session.save(device);
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
	public boolean addActuatorListToDevice(int deviceId, List<Actuator> actuatorList) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Device device = (Device) session.get(Device.class, deviceId);
			device.addActuatorListToDevice(actuatorList);
			session.save(device);
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
